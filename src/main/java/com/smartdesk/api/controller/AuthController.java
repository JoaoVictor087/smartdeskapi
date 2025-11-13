package com.smartdesk.api.controller;

import com.smartdesk.api.DTOs.request.CriarUsuarioRequestDTO;
import com.smartdesk.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody CriarUsuarioRequestDTO dto){
        authService.cadastrarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
