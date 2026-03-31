package com.drivingtest.portal.dto;

import jakarta.validation.constraints.NotNull;

/**
 * Request body for submitting an answer during an active exam session.
 * {@code answerId} may be {@code null} to represent a conscious skip.
 */
public record SubmitAnswerRequest(
        @NotNull Integer sequenceNumber,
        Long answerId
) {}
