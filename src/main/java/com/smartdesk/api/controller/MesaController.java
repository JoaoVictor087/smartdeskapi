package com.smartdesk.api.controller;

import com.smartdesk.api.DTOs.request.CriarMesaRequestDTO;
import com.smartdesk.api.service.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesas")
@RequiredArgsConstructor
public class MesaController {

    private final MesaService mesaService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> criarMesa(@RequestBody CriarMesaRequestDTO dto) {
        mesaService.criarMesa(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
