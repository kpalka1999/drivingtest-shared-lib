package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.QuestionCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * Request body for {@code POST /internal/users/{userId}/category-completion}.
 * <p>
 * Sent by exam-service after a {@code CATEGORY_EXAM} session finalises with
 * {@code passed=true}. Idempotent on the user-service side: subsequent calls
 * never clear {@code completedAt} and only raise {@code bestScore}.
 *
 * @param category    the category that was just passed
 * @param licenseType the licence the exam was drawn for
 * @param score       raw point score (0..maxScore inclusive); upserted into
 *                    {@code best_score} only if it exceeds the existing value
 */
public record CategoryCompletionRequest(
        @NotNull QuestionCategory category,
        @NotNull LicenseType licenseType,
        @PositiveOrZero int score
) {}
