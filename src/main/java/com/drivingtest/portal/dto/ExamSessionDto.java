package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.SessionStatus;

import java.time.Instant;

/**
 * Status overview DTO for an exam session.
 * Does NOT include per-question answer details — use {@link ExamResultDto}
 * for full results after the session is complete.
 */
public record ExamSessionDto(
        Long id,
        Long userId,
        LicenseType licenseType,
        Instant startedAt,
        Instant finishedAt,
        Instant sessionDeadline,
        SessionStatus status,
        int score,
        int maxScore,
        int passingScore,
        boolean passed,
        int questionsAnswered,
        int totalQuestions
) {}
