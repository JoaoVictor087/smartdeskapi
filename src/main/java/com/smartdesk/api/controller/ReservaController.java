package com.smartdesk.api.controller;

import com.smartdesk.api.DTOs.request.CriarReservaRequestDTO;
import com.smartdesk.api.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> criarReserva(@RequestBody CriarReservaRequestDTO dto) {
        reservaService.criarReserva(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
