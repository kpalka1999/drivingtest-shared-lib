package com.drivingtest.portal.exception;

/**
 * Thrown when an outgoing e-mail cannot be delivered due to an SMTP or messaging error.
 * Mapped to HTTP 503 by GlobalExceptionHandler so callers receive a retryable
 * error code rather than a generic 500.
 */
public class MailDeliveryException extends RuntimeException {

    public MailDeliveryException(String message, Throwable cause) {
        super(message, cause);
    }
}
