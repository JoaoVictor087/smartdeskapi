package com.smartdesk.api.DTOs.response;

public record CriarUsuarioResponseDTO(
        Long id,
        String nome,
        String email
){ }
