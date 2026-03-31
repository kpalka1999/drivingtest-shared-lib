package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.SessionStatus;

/**
 * Response body for {@code POST /api/v1/exams/sessions/{id}/answers}.
 * <p>
 * Reports the operational outcome of the submitted answer (timed-out, skipped)
 * and the current session progress counters.
 * <p>
 * <strong>Correctness and per-question points are intentionally omitted.</strong>
 */
public record SubmitAnswerResponse(
        int sequenceNumber,
        boolean timedOut,
        boolean skipped,
        int currentScore,
        int questionsAnswered,
        int totalQuestions,
        boolean sessionFinished,
        SessionStatus sessionStatus
) {}
