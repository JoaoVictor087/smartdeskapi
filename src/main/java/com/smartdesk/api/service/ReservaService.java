package com.smartdesk.api.service;

import com.smartdesk.api.DTOs.request.CriarReservaRequestDTO;
import com.smartdesk.api.entity.Mesa;
import com.smartdesk.api.entity.Reserva;
import com.smartdesk.api.entity.Usuario;
import com.smartdesk.api.exceptions.ValidacaoException;
import com.smartdesk.api.repository.MesaRepository;
import com.smartdesk.api.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final MesaRepository mesaRepository;

    @Transactional
    public void criarReserva(CriarReservaRequestDTO dto) {

        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Mesa mesa = mesaRepository.findById(dto.idMesa())
                .orElseThrow(() -> new ValidacaoException("Mesa não encontrada. ID: " + dto.idMesa()));

        validarDatas(dto.dataInicio(), dto.dataFim());

        List<Reserva> conflitos = reservaRepository.findConflitosDeHorario(
                dto.idMesa(),
                dto.dataInicio(),
                dto.dataFim()
        );

        if (!conflitos.isEmpty()) {
            throw new ValidacaoException("Conflito de horário. A mesa já está reservada neste período.");
        }

        Reserva novaReserva = Reserva.builder()
                .usuario(usuarioLogado)
                .mesa(mesa)
                .dataInicio(dto.dataInicio())
                .dataFim(dto.dataFim())
                .build();

        reservaRepository.save(novaReserva);
    }

    private void validarDatas(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio.isBefore(LocalDateTime.now())) {
            throw new ValidacaoException("A data de início não pode ser no passado.");
        }
        if (inicio.isAfter(fim) || inicio.isEqual(fim)) {
            throw new ValidacaoException("A data de início deve ser anterior à data de fim.");
        }
    }
}
