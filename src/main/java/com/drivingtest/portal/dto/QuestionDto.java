package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.*;

import java.util.List;
import java.util.Set;

/**
 * DTO representing a question with its answer options.
 * The {@code isCorrect} flag on each {@link AnswerDto} is hidden (null)
 * when serving questions during an active exam session.
 */
public record QuestionDto(
        Long id,
        String content,
        String contentEn,
        String contentDe,
        String contentUk,
        String explanation,
        String explanationEn,
        String explanationDe,
        String explanationUk,
        QuestionCategory category,
        Set<LicenseType> licenseTypes,
        DifficultyLevel difficultyLevel,
        QuestionType questionType,
        int pointValue,
        String mediaReference,
        MediaType mediaType,
        String blockName,
        String sourceIdentifier,
        List<AnswerDto> answers
) {}
