package com.drivingtest.portal.enums;

/**
 * Subscription plan tiers.
 *
 * <p>Structural data only: code (= enum name) and duration in days.
 * Pricing lives in the payment-service {@code plans} table because it is
 * commerce-side and may change per region / promotion.
 */
public enum SubscriptionPlan {

    WEEK_7(7),
    MONTH_1(30),
    MONTH_3(90);

    private final int durationDays;

    SubscriptionPlan(int durationDays) {
        this.durationDays = durationDays;
    }

    public int getDurationDays() {
        return durationDays;
    }
}
