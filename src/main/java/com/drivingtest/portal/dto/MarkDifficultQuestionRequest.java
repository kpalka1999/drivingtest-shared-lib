package com.drivingtest.portal.dto;

import jakarta.validation.constraints.NotNull;

/**
 * Request body for {@code POST /api/v1/users/difficult-questions}.
 * The authenticated user's ID is taken from the gateway-injected header — not the body.
 */
public record MarkDifficultQuestionRequest(
        @NotNull Long questionId
) {}
