package com.smartdesk.api.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CriarReservaRequestDTO(
        @NotNull
        @NotBlank
        Long idMesa,

        @NotNull
        @NotBlank
        LocalDateTime dataInicio,

        @NotNull
        @NotBlank
        LocalDateTime dataFim
) {}