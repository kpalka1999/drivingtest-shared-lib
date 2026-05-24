package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.QuestionCategory;
import jakarta.validation.constraints.NotNull;

/**
 * Request body for {@code POST /api/v1/learn/exam/start}.
 * <p>
 * The category must currently classify as {@code FULL} mode (≥ 20 questions for
 * the licence) and the user's knowledge phase must be complete — otherwise the
 * server rejects with {@code CATEGORY_EXAM_UNAVAILABLE_TRAINING_ONLY} or
 * {@code KNOWLEDGE_PHASE_INCOMPLETE} respectively.
 */
public record StartCategoryExamRequest(
        @NotNull LicenseType licenseType,
        @NotNull QuestionCategory category
) {}
