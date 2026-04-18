package com.drivingtest.portal.dto;

/**
 * Response body for {@code POST /api/v1/exams/sessions/{id}/answers}
 * when the session is of type {@code PRACTICE} (tryb nauki).
 * <p>
 * Unlike {@link SubmitAnswerResponse}, this payload intentionally reveals correctness,
 * awarded points, the correct answer ID and the explanation — so the learner can review
 * the question before advancing.
 * <p>
 * The operational counters (sequence, skipped, timed-out, session progress) are delegated
 * to the embedded {@link SubmitAnswerResponse} so the two flows share a single source of
 * truth for progress semantics.
 */
public record PracticeSubmitResponse(
        SubmitAnswerResponse progress,
        boolean correct,
        int pointsAwarded,
        Long correctAnswerId,
        String explanation
) {}
