package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.CategoryLearningMode;
import com.drivingtest.portal.enums.QuestionCategory;

/**
 * One tile in the "Nauka po kategoriach" lobby grid.
 * <p>
 * Returned for each of the 12 {@link QuestionCategory} values for the user's selected
 * {@link com.drivingtest.portal.enums.LicenseType}. The frontend renders progress
 * (viewed / total) and a checkmark when {@code completed} is true.
 *
 * @param category        the category enum value (translated label looked up via i18n)
 * @param mode            {@code FULL} (knowledge + exam) or {@code TRAINING_ONLY} (knowledge only)
 * @param totalQuestions  count of active questions in this category for the selected licence
 * @param viewedItems     count of items the user has viewed (intro + sections + questions)
 * @param totalItems      total items in the knowledge journey (intro + sections + questions)
 * @param completed       true once category completion criteria are met (mode-dependent)
 * @param bestScore       best exam score the user has achieved (FULL mode only); null otherwise
 */
public record CategoryTileDto(
        QuestionCategory category,
        CategoryLearningMode mode,
        int totalQuestions,
        int viewedItems,
        int totalItems,
        boolean completed,
        Integer bestScore
) {}
