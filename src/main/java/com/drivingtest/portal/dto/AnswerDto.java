package com.drivingtest.portal.dto;

/**
 * DTO representing a single answer option for a question.
 */
public record AnswerDto(
        Long id,
        String content,
        String contentEn,
        String contentDe,
        int displayOrder,
        Boolean isCorrect   // null when the question is served to a student (hidden)
) {}
