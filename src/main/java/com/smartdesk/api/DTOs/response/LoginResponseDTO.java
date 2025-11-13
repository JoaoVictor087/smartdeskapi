package com.smartdesk.api.DTOs.response;

public record LoginResponseDTO(
        String acessToken,
        String refreshToken,
        Long userId
){
}
