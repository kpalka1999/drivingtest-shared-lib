package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;

import java.util.List;

/**
 * Response body for {@code GET /api/v1/learn/overview?licenseType=&locale=}.
 * <p>
 * Always contains exactly 12 tiles — one per {@link com.drivingtest.portal.enums.QuestionCategory}
 * value — ordered by enum declaration order. Categories with no questions for the selected
 * licence still render as a tile with {@code mode=TRAINING_ONLY} and {@code totalQuestions=0}.
 */
public record CategoryLearningOverviewDto(
        LicenseType licenseType,
        List<CategoryTileDto> tiles
) {}
