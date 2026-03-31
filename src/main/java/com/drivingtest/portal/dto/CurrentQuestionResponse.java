package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.MediaType;
import com.drivingtest.portal.enums.QuestionType;

import java.time.Instant;
import java.util.List;

/**
 * Response body for {@code GET /api/v1/exams/sessions/{id}/question}.
 * Exposes the current question's content and answer options — but never
 * which option is correct ({@link AnswerOptionDto} omits the {@code isCorrect} flag).
 */
public record CurrentQuestionResponse(
        Long sessionId,
        int sequenceNumber,
        int totalQuestions,
        int questionsAnswered,
        Long questionId,
        String questionContent,
        String questionContentEn,
        String questionContentDe,
        QuestionType questionType,
        String mediaReference,
        MediaType mediaType,
        List<AnswerOptionDto> answers,
        Instant presentedAt,
        Instant answerDeadline,
        Instant sessionDeadline
) {}
