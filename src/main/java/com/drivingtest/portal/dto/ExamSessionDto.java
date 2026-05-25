package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.QuestionCategory;
import com.drivingtest.portal.enums.SessionStatus;
import com.drivingtest.portal.enums.SessionType;

import java.time.Instant;

/**
 * Status overview DTO for an exam session.
 * Does NOT include per-question answer details — use {@link ExamResultDto}
 * for full results after the session is complete.
 * <p>
 * {@code category} is non-null only for {@link SessionType#CATEGORY_EXAM}
 * sessions; null for every other session type. Lets clients (e.g. the exam
 * history page) deep-link CATEGORY_EXAM sessions back to their category
 * landing without an extra round-trip.
 */
public record ExamSessionDto(
        Long id,
        Long userId,
        LicenseType licenseType,
        SessionType sessionType,
        Instant startedAt,
        Instant finishedAt,
        Instant sessionDeadline,
        SessionStatus status,
        int score,
        int maxScore,
        int passingScore,
        boolean passed,
        int questionsAnswered,
        int totalQuestions,
        QuestionCategory category
) {}
