package com.smartdesk.api.DTOs.request;

import java.time.LocalDateTime;

public record CriarReservaRequestDTO(
        Long idMesa,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {}