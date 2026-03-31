package com.drivingtest.portal.dto;

import java.time.Instant;

/**
 * DTO representing the outcome of a single question slot within a session.
 * Used in {@link ExamResultDto#details()} after the session is complete.
 */
public record ExamAnswerDto(
        int sequenceNumber,
        Long questionId,
        String questionContent,
        Long selectedAnswerId,
        String selectedAnswerContent,
        boolean correct,
        boolean skipped,
        boolean timedOut,
        int pointsAwarded,
        Instant presentedAt,
        Instant answerDeadline,
        Instant answeredAt
) {}
