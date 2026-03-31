package com.drivingtest.portal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response body for a successful registration.
 */
@Schema(description = "Response returned after successful user registration")
public record RegisterResponse(
        @Schema(description = "Newly created user's database ID", example = "42")
        Long userId,

        @Schema(description = "Registered e-mail address", example = "jan.kowalski@example.com")
        String email,

        @Schema(description = "Human-readable confirmation message",
                example = "Check your email to verify your account")
        String message
) {}
