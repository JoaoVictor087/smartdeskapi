package com.smartdesk.api.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDTO(
        @NotNull
        @NotBlank
        String email,

        @NotNull
        @NotBlank
        String senha
) {
}
