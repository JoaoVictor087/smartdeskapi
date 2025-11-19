package com.smartdesk.api.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AtualizarReservaRequestDTO(
        @NotNull
        @NotBlank
        Long idReserva,

        @NotNull
        @NotBlank
        LocalDateTime novaDataInicio,

        @NotNull
        @NotBlank
        LocalDateTime novaDataFim
) {
}
