package com.smartdesk.api.controller;

import com.smartdesk.api.DTOs.request.CriarMesaRequestDTO;
import com.smartdesk.api.entity.Mesa;
import com.smartdesk.api.service.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/disponiveis")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Mesa>> getMesasDisponiveis(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim
    ) {
        List<Mesa> mesas = mesaService.getMesasDisponiveis(dataInicio, dataFim);
        return ResponseEntity.ok(mesas);
    }
}
