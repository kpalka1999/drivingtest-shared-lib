package com.drivingtest.portal.exception;

/**
 * Thrown for account-state problems (disabled, unverified, email conflict) that
 * should result in 403 or 409 responses rather than a generic 500.
 */
public class AccountException extends RuntimeException {

    private final AccountExceptionType type;

    /**
     * @param message description of the problem
     * @param type    the specific account-state issue
     */
    public AccountException(String message, AccountExceptionType type) {
        super(message);
        this.type = type;
    }

    /**
     * Returns the type of account exception, used by the global handler to
     * choose the appropriate HTTP status code.
     *
     * @return the exception type
     */
    public AccountExceptionType getType() {
        return type;
    }

    /** Enum describing specific account-level error conditions. */
    public enum AccountExceptionType {
        EMAIL_ALREADY_EXISTS,
        ACCOUNT_DISABLED,
        ACCOUNT_NOT_VERIFIED,
        TOKEN_EXPIRED,
        TOKEN_ALREADY_USED,
        TOKEN_INVALID,
        TOKEN_LOCKED_OUT,
        SUBSCRIPTION_CONFLICT,
        USER_NOT_FOUND
    }
}
