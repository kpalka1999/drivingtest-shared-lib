package com.drivingtest.portal.dto;

import java.time.Instant;

/**
 * DTO representing the outcome of a single question slot within a session.
 * Used in {@link ExamResultDto#details()} after the session is complete.
 * <p>
 * {@code explanation} and {@code correctAnswerId} are populated for terminal sessions
 * (results view) regardless of session type — they are not revealed during an
 * in-progress EXAM session (see {@link SubmitAnswerResponse}).
 */
public record ExamAnswerDto(
        int sequenceNumber,
        Long questionId,
        String questionContent,
        Long selectedAnswerId,
        String selectedAnswerContent,
        Long correctAnswerId,
        String correctAnswerContent,
        boolean correct,
        boolean skipped,
        boolean timedOut,
        int pointsAwarded,
        String explanation,
        Instant presentedAt,
        Instant answeredAt
) {}
