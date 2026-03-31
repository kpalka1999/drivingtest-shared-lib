package com.drivingtest.portal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Request body for {@code POST /api/auth/login}.
 */
@Schema(description = "Login credentials")
public record LoginRequest(

        @Email(message = "A valid e-mail address is required")
        @NotBlank(message = "E-mail is required")
        @Schema(example = "jan.kowalski@example.com")
        String email,

        @NotBlank(message = "Password is required")
        @Schema(example = "Secure@123")
        String password
) {}
