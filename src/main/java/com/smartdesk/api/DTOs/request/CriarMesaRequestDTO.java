package com.smartdesk.api.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarMesaRequestDTO(
        @NotNull
        @NotBlank
        String nome,

        @NotNull
        @NotBlank
        String localizacao,

        int capacidadeMesa
) {}