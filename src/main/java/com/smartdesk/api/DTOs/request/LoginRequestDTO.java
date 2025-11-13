package com.smartdesk.api.DTOs.request;

public record LoginRequestDTO(
        String email,
        String senha
) {
}
