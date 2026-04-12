package com.drivingtest.portal.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * Subscription plan status embedded in {@link AuthResponse} and returned
 * by the subscription endpoints.
 */
@Schema(description = "Current subscription plan status")
public record PlanStatusDto(

        @Schema(description = "Whether the user has an active (non-expired) subscription")
        boolean active,

        @Schema(description = "Plan identifier (WEEK_7, MONTH_1, MONTH_3), null if no subscription", example = "MONTH_1")
        String plan,

        @Schema(description = "When the current plan expires (UTC), null if no subscription")
        LocalDateTime expiresAt
) {}
