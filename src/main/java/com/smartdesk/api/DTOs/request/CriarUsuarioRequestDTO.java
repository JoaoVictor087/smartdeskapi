package com.smartdesk.api.DTOs.request;

public record CriarUsuarioRequestDTO(
        String nome,
        String email,
        String senha
) {
}
