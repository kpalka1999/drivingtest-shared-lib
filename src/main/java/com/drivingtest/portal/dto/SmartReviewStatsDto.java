package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.DifficultyLevel;

/**
 * Lightweight stats for the Smart Review sidebar badge and lobby header.
 * <p>
 * All counts are filtered by the calling user's chosen {@code licenseType}: a row in
 * {@code question_review_state} only counts if its {@code license_types_csv} contains
 * the requested licence.
 *
 * @param dueNow         questions whose {@code next_due_at} is at or before "now"
 * @param dueToday       questions due before end-of-today (UTC), inclusive of {@code dueNow}
 * @param totalTracked   total questions the user has ever attempted for this licence
 * @param weakestScope   the scope with the lower average {@code ease_factor}, or {@code null}
 *                       when the user has no tracked questions yet
 */
public record SmartReviewStatsDto(
        int dueNow,
        int dueToday,
        int totalTracked,
        DifficultyLevel weakestScope
) {}
