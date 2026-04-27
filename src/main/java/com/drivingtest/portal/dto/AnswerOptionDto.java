package com.drivingtest.portal.dto;

/**
 * A single answer option presented to the candidate during an active exam.
 * Does NOT expose the {@code isCorrect} flag — correct answers must not
 * leak while a session is in progress.
 */
public record AnswerOptionDto(
        Long id,
        String content,
        String contentEn,
        String contentDe,
        String contentUk,
        int displayOrder
) {}
