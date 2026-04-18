package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.SessionStatus;
import com.drivingtest.portal.enums.SessionType;

import java.time.Instant;
import java.util.List;

/**
 * Full result DTO returned after an exam session reaches a terminal state.
 * Includes per-question details with correct-answer information.
 * Only available when {@code status != IN_PROGRESS}.
 */
public record ExamResultDto(
        Long sessionId,
        LicenseType licenseType,
        SessionType sessionType,
        int score,
        int maxScore,
        int passingScore,
        boolean passed,
        SessionStatus status,
        Instant startedAt,
        Instant finishedAt,
        int totalQuestions,
        int correctAnswers,
        int skippedQuestions,
        int timedOutQuestions,
        List<ExamAnswerDto> details
) {}
