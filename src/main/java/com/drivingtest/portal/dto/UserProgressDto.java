package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.QuestionCategory;

import java.time.LocalDateTime;

/**
 * DTO for a user's learning progress in a single category.
 */
public record UserProgressDto(
        QuestionCategory category,
        LicenseType licenseType,
        int totalAttempts,
        int correctAttempts,
        double accuracyPercent,
        LocalDateTime lastPracticed
) {}
