package com.drivingtest.portal.dto.auth;

import com.drivingtest.portal.enums.SubscriptionPlan;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request body for {@code POST /internal/subscriptions/activate}, called by
 * payment-service after a P24 webhook confirms a successful payment.
 *
 * <p>Idempotent on {@code paymentReference}: if a subscription row already
 * exists for that reference (webhook replay), auth-service returns the
 * existing row instead of creating a duplicate.
 */
@Schema(description = "Internal request to activate a subscription after payment confirmation")
public record InternalActivateSubscriptionRequest(

        @Schema(description = "auth-service user id", example = "42")
        @NotNull
        Long userId,

        @Schema(description = "Plan to activate", example = "MONTH_1")
        @NotNull
        SubscriptionPlan plan,

        @Schema(description = "Idempotency key — payment-service session_id (UUID string). " +
                "Replays of the same webhook return the existing subscription row.",
                example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
        @NotBlank
        String paymentReference
) {}
