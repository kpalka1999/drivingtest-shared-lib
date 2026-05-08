package com.drivingtest.portal.dto.auth;

import com.drivingtest.portal.enums.SubscriptionPlan;
import com.drivingtest.portal.enums.SubscriptionState;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * Subscription plan status embedded in {@link AuthResponse} and returned
 * by the subscription endpoints. Populated by auth-service
 * {@code SubscriptionService.getStatus(userId)}.
 *
 * <p>The first three fields preserve the original v1 JSON shape so older
 * frontend builds keep working. The four trailing fields drive the renewal
 * banner and gating UX added with the payment module.
 */
@Schema(description = "Current subscription plan status")
public record PlanStatusDto(

        @Schema(description = "Whether the user currently has an active (non-expired) subscription")
        boolean active,

        @Schema(description = "Plan identifier (WEEK_7, MONTH_1, MONTH_3); null if no active subscription",
                example = "MONTH_1", nullable = true)
        SubscriptionPlan plan,

        @Schema(description = "When the current plan expires (UTC); null if no active subscription",
                nullable = true)
        LocalDateTime expiresAt,

        @Schema(description = "Lifecycle state derived from subscription rows", example = "ACTIVE")
        SubscriptionState state,

        @Schema(description = "True if the user can buy a plan now: NONE/EXPIRED, " +
                "or ACTIVE within the soft-renewal window (≤7 days) with no queued renewal")
        boolean renewalEligible,

        @Schema(description = "Days remaining until expiry; null if no active subscription",
                example = "5", nullable = true)
        Integer daysUntilExpiry,

        @Schema(description = "True when a future-dated subscription row already exists, " +
                "waiting to auto-activate when the current one expires")
        boolean hasQueuedRenewal
) {

    /** State for a user who has never purchased a plan. */
    public static PlanStatusDto none() {
        return new PlanStatusDto(false, null, null,
                SubscriptionState.NONE, true, null, false);
    }

    /** State for a user whose subscriptions have all expired. */
    public static PlanStatusDto expired() {
        return new PlanStatusDto(false, null, null,
                SubscriptionState.EXPIRED, true, null, false);
    }
}
