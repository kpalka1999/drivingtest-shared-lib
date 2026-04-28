package com.drivingtest.portal.dto;

import java.time.Instant;

/**
 * DTO representing the outcome of a single question slot within a session.
 * Used in {@link ExamResultDto#details()} after the session is complete.
 * <p>
 * {@code explanation} and {@code correctAnswerId} are populated for terminal sessions
 * (results view) regardless of session type — they are not revealed during an
 * in-progress EXAM session (see {@link SubmitAnswerResponse}).
 * <p>
 * Locale fields ({@code *En}, {@code *De}, {@code *Uk}) are nullable. Polish ({@code *Content},
 * {@code explanation}) is the canonical/source language and always populated when the source
 * row has the data; translations are present only when the source question carries a translation
 * and may be {@code null} for legacy {@code session_questions} rows created before the i18n
 * snapshot columns were added (V8).
 */
public record ExamAnswerDto(
        int sequenceNumber,
        Long questionId,
        String questionContent,
        String questionContentEn,
        String questionContentDe,
        String questionContentUk,
        Long selectedAnswerId,
        String selectedAnswerContent,
        String selectedAnswerContentEn,
        String selectedAnswerContentDe,
        String selectedAnswerContentUk,
        Long correctAnswerId,
        String correctAnswerContent,
        String correctAnswerContentEn,
        String correctAnswerContentDe,
        String correctAnswerContentUk,
        boolean correct,
        boolean skipped,
        boolean timedOut,
        int pointsAwarded,
        String explanation,
        String explanationEn,
        String explanationDe,
        String explanationUk,
        Instant presentedAt,
        Instant answeredAt
) {}
