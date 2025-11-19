package com.smartdesk.api.DTOs.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AtualizarReservaRequestDTO(
        @NotNull
        Long idReserva,

        @NotNull
        LocalDateTime novaDataInicio,

        @NotNull
        LocalDateTime novaDataFim
) {
}
