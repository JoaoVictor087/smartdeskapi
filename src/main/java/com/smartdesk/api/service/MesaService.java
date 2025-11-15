package com.smartdesk.api.service;

import com.smartdesk.api.DTOs.request.CriarMesaRequestDTO;
import com.smartdesk.api.entity.Mesa;
import com.smartdesk.api.entity.Usuario;
import com.smartdesk.api.enums.StatusMesa;
import com.smartdesk.api.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MesaService {
    private final MesaRepository mesaRepository;

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
}
