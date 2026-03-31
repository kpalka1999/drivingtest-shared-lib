package com.drivingtest.portal.dto.auth;

import com.drivingtest.portal.enums.LicenseType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Request body for {@code POST /api/auth/register}.
 */
@Schema(description = "New-user registration payload")
public record RegisterRequest(

        @NotBlank(message = "First name is required")
        @Size(max = 100, message = "First name must not exceed 100 characters")
        @Schema(example = "Jan")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(max = 100, message = "Last name must not exceed 100 characters")
        @Schema(example = "Kowalski")
        String lastName,

        @Email(message = "A valid e-mail address is required")
        @NotBlank(message = "E-mail is required")
        @Schema(example = "jan.kowalski@example.com")
        String email,

        /**
         * Password must be at least 8 characters and contain at least one uppercase
         * letter, one digit, and one special character.
         */
        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters")
        @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$",
            message = "Password must contain at least one uppercase letter, one digit, and one special character"
        )
        @Schema(example = "Secure@123")
        String password,

        @NotNull(message = "Target licence type is required")
        @Schema(example = "B")
        LicenseType licenseTypeTarget
) {}
