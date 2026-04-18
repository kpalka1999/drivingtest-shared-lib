package com.drivingtest.portal.enums;

/**
 * Distinguishes the lifecycle semantics of an exam session.
 * <p>
 * {@code EXAM} sessions follow the official PKK/WORD template (20 basic + 12 specialized,
 * 25 min total deadline, passing threshold). {@code PRACTICE} sessions are user-curated
 * lists of questions — no template, no passing threshold, no session-wide deadline —
 * and reveal correctness after every answer.
 */
public enum SessionType {
    EXAM,
    PRACTICE
}
