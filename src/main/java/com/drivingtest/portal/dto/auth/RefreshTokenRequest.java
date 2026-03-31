package com.drivingtest.portal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * Request body for {@code POST /api/auth/refresh}.
 */
@Schema(description = "Refresh-token rotation request")
public record RefreshTokenRequest(
        @NotBlank(message = "Refresh token is required")
        @Schema(example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
        String refreshToken
) {}
