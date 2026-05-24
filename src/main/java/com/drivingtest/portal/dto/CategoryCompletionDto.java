package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.QuestionCategory;

import java.time.LocalDateTime;

/**
 * Per-(user, category, licence) completion record returned by
 * {@code GET /internal/users/{userId}/category-completions}.
 * <p>
 * Only categories the user has actually completed appear in the response —
 * non-completed rows (or categories with no {@code UserProgress} row yet)
 * are omitted entirely.
 *
 * @param category    the completed category
 * @param licenseType the licence the completion was achieved against
 * @param completedAt timestamp of the first passing exam attempt
 * @param bestScore   highest score across all attempts (raw points, max 20)
 */
public record CategoryCompletionDto(
        QuestionCategory category,
        LicenseType licenseType,
        LocalDateTime completedAt,
        Integer bestScore
) {}
