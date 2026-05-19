package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import jakarta.validation.constraints.NotNull;

/**
 * Request body for {@code POST /api/v1/exams/sessions/smart-review}.
 * <p>
 * {@code licenseType} is required — the SmartReview lobby requires the user to pick a
 * licence before starting, so the backend filters due/lapsed cards to questions whose
 * {@code license_types_csv} contains this value. The review-state row schedule itself
 * is shared across licences (single row per {@code (user_id, question_id)} pair).
 */
public record StartSmartReviewRequest(
        @NotNull LicenseType licenseType
) {}
