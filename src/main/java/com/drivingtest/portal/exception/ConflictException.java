package com.drivingtest.portal.exception;

/**
 * Thrown when a request conflicts with existing application state (HTTP 409).
 * Carries a specific {@link ErrorCode} so the frontend can distinguish between
 * different conflict types (active exam session, sequence mismatch, etc.).
 */
public class ConflictException extends RuntimeException {

    private final ErrorCode errorCode;

    public ConflictException(String message) {
        this(ErrorCode.CONFLICT, message);
    }

    public ConflictException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
