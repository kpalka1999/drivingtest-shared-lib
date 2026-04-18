package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;

/**
 * Request body for {@code POST /api/v1/exams/sessions/practice}.
 * <p>
 * The set of questions is resolved server-side from the user's own difficult-question marks
 * (user-service) — the client never supplies raw question IDs, which prevents leaking
 * correct answers through the practice reveal mechanism.
 * <p>
 * {@code licenseTypeFilter} is optional: when {@code null}, all marked questions are used
 * regardless of their licence types.
 */
public record StartPracticeRequest(
        LicenseType licenseTypeFilter
) {}
