package com.smartdesk.api.DTOs.response;

public record LoginResponseDTO(
        String accessToken,
        String refreshToken,
        Long userId
){
}
