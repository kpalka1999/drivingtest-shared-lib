package com.drivingtest.portal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Request body for {@code POST /api/auth/verify-email}.
 */
@Schema(description = "E-mail verification request with the 6-digit code")
public record VerifyEmailRequest(

        @Email(message = "A valid e-mail address is required")
        @NotBlank(message = "E-mail is required")
        @Schema(example = "jan.kowalski@example.com")
        String email,

        @NotBlank(message = "Verification code is required")
        @Pattern(regexp = "\\d{6}", message = "Verification code must be exactly 6 digits")
        @Schema(example = "482931")
        String code
) {}
