package com.drivingtest.portal.enums;

/**
 * Derived lifecycle state for the user's subscription, computed from rows in
 * {@code subscriptions}. Not persisted as a column.
 *
 * <ul>
 *   <li>{@link #NONE} — user has never purchased a plan</li>
 *   <li>{@link #ACTIVE} — there exists a row with {@code activated_at <= now < expires_at}</li>
 *   <li>{@link #EXPIRED} — at least one row exists but all are expired</li>
 * </ul>
 *
 * <p>{@code PENDING_PAYMENT} is intentionally not modelled here — it lives in
 * payment-service and is only meaningful while polling on {@code /subscribe/result}.
 */
public enum SubscriptionState {
    NONE,
    ACTIVE,
    EXPIRED
}
