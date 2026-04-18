package com.drivingtest.portal.dto;

import java.time.Instant;

/**
 * A single "marked as difficult" record for a user.
 * Returned from {@code GET /api/v1/users/difficult-questions}.
 */
public record DifficultQuestionDto(
        Long id,
        Long questionId,
        Instant markedAt
) {}
