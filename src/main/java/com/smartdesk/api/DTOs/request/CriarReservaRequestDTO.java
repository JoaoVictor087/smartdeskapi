package com.smartdesk.api.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CriarReservaRequestDTO(
        @NotNull
        Long idMesa,

        @NotNull
        LocalDateTime dataInicio,

        @NotNull
        LocalDateTime dataFim
) {}