package com.smartdesk.api.DTOs.request;

import com.smartdesk.api.enums.ROLES;

public record CriarUsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        ROLES role
) {
}
