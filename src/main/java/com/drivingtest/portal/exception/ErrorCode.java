package com.drivingtest.portal.exception;

/**
 * Stable, machine-readable error codes that flow on every {@link com.drivingtest.portal.dto.ErrorResponse}.
 * The frontend translates these into the user's locale via the {@code errors.<CODE>} message key.
 *
 * Contract: Add new codes ONLY here. Never invent ad-hoc strings in service code.
 * Renaming a code is a breaking change for the frontend translation map.
 */
public enum ErrorCode {
    // ── Auth ──────────────────────────────────────────────────────────────────
    AUTH_INVALID_CREDENTIALS,
    AUTH_EMAIL_NOT_VERIFIED,
    AUTH_USER_DISABLED,
    AUTH_RATE_LIMITED,
    AUTH_TOKEN_EXPIRED,
    AUTH_TOKEN_INVALID,
    AUTH_REGISTRATION_EMAIL_TAKEN,
    AUTH_VERIFICATION_CODE_INVALID,
    AUTH_PASSWORD_RESET_TOKEN_INVALID,
    AUTH_CURRENT_PASSWORD_WRONG,

    // ── Exam ──────────────────────────────────────────────────────────────────
    EXAM_SESSION_ACTIVE,
    EXAM_SESSION_NOT_FOUND,
    EXAM_SESSION_NOT_TERMINAL,
    EXAM_SESSION_TIMED_OUT,
    EXAM_SEQUENCE_MISMATCH,
    EXAM_INSUFFICIENT_QUESTIONS,
    EXAM_TEMPLATE_NOT_FOUND,

    // ── Practice ──────────────────────────────────────────────────────────────
    PRACTICE_SESSION_NOT_FOUND,
    PRACTICE_NO_DIFFICULT_QUESTIONS,

    // ── Question ──────────────────────────────────────────────────────────────
    QUESTION_NOT_FOUND,
    QUESTION_INVALID_FILTER,

    // ── User ──────────────────────────────────────────────────────────────────
    USER_NOT_FOUND,
    USER_FORBIDDEN,

    // ── Media ─────────────────────────────────────────────────────────────────
    MEDIA_NOT_FOUND,
    MEDIA_PATH_TRAVERSAL,

    // ── Generic / fallback ────────────────────────────────────────────────────
    VALIDATION_FAILED,
    RESOURCE_NOT_FOUND,
    FORBIDDEN,
    CONFLICT,
    INTERNAL_ERROR
}
