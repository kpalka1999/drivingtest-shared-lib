package com.drivingtest.portal.dto.auth;

import com.drivingtest.portal.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response body returned on successful login and token refresh.
 */
@Schema(description = "JWT token pair and basic user information")
public record AuthResponse(

        @Schema(description = "Short-lived JWT access token (15 minutes)", example = "eyJhbG...")
        String accessToken,

        @Schema(description = "Long-lived opaque refresh token (7 days)", example = "f47ac10b-58cc...")
        String refreshToken,

        @Schema(description = "Token type", example = "Bearer")
        String tokenType,

        @Schema(description = "Access-token lifetime in seconds", example = "900")
        long expiresIn,

        @Schema(description = "Authenticated user's public profile")
        UserInfo user
) {
    /** Embedded public profile of the authenticated user. */
    @Schema(description = "Basic user information included in the auth response")
    public record UserInfo(
            Long id,
            String email,
            String firstName,
            String lastName,
            UserRole role
    ) {}
}
