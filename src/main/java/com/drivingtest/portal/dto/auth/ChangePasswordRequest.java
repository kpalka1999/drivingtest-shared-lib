package com.drivingtest.portal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Request body for {@code POST /api/auth/change-password} (requires authentication).
 */
@Schema(description = "Authenticated password-change request")
public record ChangePasswordRequest(

        @NotBlank(message = "Current password is required")
        @Schema(example = "Secure@123")
        String currentPassword,

        @NotBlank(message = "New password is required")
        @Size(min = 8, message = "Password must be at least 8 characters")
        @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$",
            message = "Password must contain at least one uppercase letter, one digit, and one special character"
        )
        @Schema(example = "NewSecure@456")
        String newPassword
) {}
