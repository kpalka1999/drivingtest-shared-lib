package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.UserRole;

/**
 * Public-facing DTO for a portal user. Password hash is never included.
 */
public record UserDto(
        Long id,
        String email,
        String firstName,
        String lastName,
        UserRole role,
        LicenseType licenseTypeTarget,
        boolean isEnabled,
        boolean isVerified
) {}
