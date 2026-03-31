package com.drivingtest.portal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Request body for {@code POST /api/auth/forgot-password}.
 * The API always returns 200 regardless of whether the e-mail exists
 * (prevents user-enumeration attacks).
 */
@Schema(description = "Forgot-password request — triggers a password-reset e-mail if the address is known")
public record ForgotPasswordRequest(

        @Email(message = "A valid e-mail address is required")
        @NotBlank(message = "E-mail is required")
        @Schema(example = "jan.kowalski@example.com")
        String email
) {}
