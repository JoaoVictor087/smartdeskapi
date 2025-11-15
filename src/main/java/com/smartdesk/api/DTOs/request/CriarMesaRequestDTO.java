package com.smartdesk.api.DTOs.request;

public record CriarMesaRequestDTO(
        String nome,
        String localizacao,
        int capacidadeMesa
) {}