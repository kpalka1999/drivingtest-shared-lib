package com.drivingtest.portal.enums;

/**
 * Classification of a {@link QuestionCategory} tile in the "Nauka po kategoriach"
 * learning module, derived from how many questions the category has for the user's
 * selected {@link LicenseType}.
 * <p>
 * {@code FULL} ({@code totalQuestions >= 20}) — both the knowledge phase and the
 * 20-question category practice exam are available; completion requires passing
 * the exam at &ge;90%.
 * <p>
 * {@code TRAINING_ONLY} ({@code totalQuestions < 20}) — only the knowledge phase
 * exists; completion is granted once every introduction, theory section, and
 * question has been viewed.
 */
public enum CategoryLearningMode {
    FULL,
    TRAINING_ONLY
}
