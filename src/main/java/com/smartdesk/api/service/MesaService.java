package com.smartdesk.api.service;

import com.smartdesk.api.DTOs.request.CriarMesaRequestDTO;
import com.smartdesk.api.entity.Mesa;
import com.smartdesk.api.entity.Usuario;
import com.smartdesk.api.enums.StatusMesa;
import com.smartdesk.api.repository.MesaRepository;
import com.smartdesk.api.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MesaService {
    private final MesaRepository mesaRepository;
    private final ReservaRepository reservaRepository;

    @Transactional
    public void criarMesa(CriarMesaRequestDTO dto) {
        Usuario empresaLogada = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Mesa novaMesa = Mesa.builder()
                .nomeMesa(dto.nome())
                .localizacao(dto.localizacao())
                .statusMesa(StatusMesa.DISPONIVEL)
                .capacidadeMesa(dto.capacidadeMesa())
                .empresa(empresaLogada)
                .build();

        mesaRepository.save(novaMesa);
    }

    @Transactional(readOnly = true)
    public List<Mesa> getMesasDisponiveis(LocalDateTime dataInicio, LocalDateTime dataFim) {

        List<Mesa> todasMesasAtivas = getMesasComStatusDisponivel();

        List<Long> idsMesasOcupadas = reservaRepository.findMesasOcupadas(dataInicio, dataFim);

        return todasMesasAtivas.stream()
                .filter(mesa -> !idsMesasOcupadas.contains(mesa.getId()))
                .collect(Collectors.toList());
    }

    public List<Mesa> getMesasComStatusDisponivel() {
        return mesaRepository.findByStatusMesa(StatusMesa.DISPONIVEL);
    }
}
