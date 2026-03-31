package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import jakarta.validation.constraints.NotNull;

/**
 * Request body for starting a new exam session.
 * The authenticated user's identity is taken from the JWT — no userId in the body.
 */
public record StartExamRequest(
        @NotNull LicenseType licenseType
) {}
