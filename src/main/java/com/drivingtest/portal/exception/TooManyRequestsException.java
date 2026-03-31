package com.drivingtest.portal.exception;

/**
 * Thrown when a client exceeds the allowed number of requests in a time window.
 * Maps to HTTP 429 Too Many Requests.
 */
public class TooManyRequestsException extends RuntimeException {

    private final long retryAfterSeconds;

    /**
     * @param message          human-readable description
     * @param retryAfterSeconds seconds the client must wait before retrying
     */
    public TooManyRequestsException(String message, long retryAfterSeconds) {
        super(message);
        this.retryAfterSeconds = retryAfterSeconds;
    }

    /**
     * Returns the number of seconds after which the client may retry.
     *
     * @return retry-after value in seconds
     */
    public long getRetryAfterSeconds() {
        return retryAfterSeconds;
    }
}
