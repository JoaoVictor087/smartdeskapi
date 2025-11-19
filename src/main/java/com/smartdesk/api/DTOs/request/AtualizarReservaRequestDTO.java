package com.smartdesk.api.DTOs.request;

import java.time.LocalDateTime;

public record AtualizarReservaRequestDTO(
        Long idReserva,
        LocalDateTime novaDataInicio,
        LocalDateTime novaDataFim
) {
}
