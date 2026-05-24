package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.CategoryLearningMode;
import com.drivingtest.portal.enums.QuestionCategory;

/**
 * Detailed per-category knowledge-journey progress returned by
 * {@code GET /api/v1/learn/{category}/progress?licenseType=&locale=}.
 * <p>
 * Drives the category landing page UI: phase cards, the unlock state of the
 * "Start exam" button (gated by {@link #knowledgeComplete}), and the
 * completion badge ({@link #examPassed} for FULL mode, {@link #knowledgeComplete}
 * alone for TRAINING_ONLY).
 *
 * @param category          the category being inspected
 * @param mode              {@code FULL} or {@code TRAINING_ONLY}
 * @param viewedItems       count of INTRO + SECTION + QUESTION items the user has viewed
 * @param totalItems        total INTRO (0 or 1) + SECTION (N) + QUESTION (M) items
 * @param knowledgeComplete true when {@code viewedItems &gt;= totalItems}
 * @param examPassed        true when the user has at least one passing CATEGORY_EXAM
 *                          on this (category, licence); always false in TRAINING_ONLY mode
 * @param bestScore         best exam score on this (category, licence), or null if no attempt
 */
public record KnowledgeProgressDto(
        QuestionCategory category,
        CategoryLearningMode mode,
        int viewedItems,
        int totalItems,
        boolean knowledgeComplete,
        boolean examPassed,
        Integer bestScore
) {}
