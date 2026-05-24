package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.QuestionCategory;

/**
 * Lightweight per-category question count, returned for each of the 12
 * {@link QuestionCategory} values from
 * {@code GET /internal/learn/category-stats?licenseType=...}.
 * <p>
 * Consumed by exam-service's {@code CategoryLearningService} when assembling
 * {@link CategoryLearningOverviewDto} so it can classify each tile as
 * {@link com.drivingtest.portal.enums.CategoryLearningMode#FULL} or
 * {@link com.drivingtest.portal.enums.CategoryLearningMode#TRAINING_ONLY}
 * without a separate round trip per category.
 */
public record CategoryStatsDto(
        QuestionCategory category,
        int totalQuestions
) {}
