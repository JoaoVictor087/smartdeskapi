package com.smartdesk.api.DTOs.response;

import com.smartdesk.api.enums.ROLES;

public record LoginResponseDTO(
        String accessToken,
        String refreshToken,
        Long userId,
        ROLES role
){
}
