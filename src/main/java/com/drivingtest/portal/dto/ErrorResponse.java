package com.drivingtest.portal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Map;

/**
 * Uniform error response body returned by GlobalExceptionHandler
 * for all error conditions (4xx, 5xx).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Standard error response envelope")
public record ErrorResponse(

        @Schema(description = "UTC timestamp of when the error occurred",
                example = "2025-01-01T12:00:00Z")
        Instant timestamp,

        @Schema(description = "HTTP status code", example = "404")
        int status,

        @Schema(description = "HTTP reason phrase", example = "Not Found")
        String error,

        @Schema(description = "Human-readable error description",
                example = "Question with id 42 not found")
        String message,

        @Schema(description = "Request path that triggered the error",
                example = "/api/v1/questions/42")
        String path,

        @Schema(description = "Unique request trace ID for log correlation",
                example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
        String traceId,

        /**
         * Per-field validation errors — only present on 400 responses from
         * Bean Validation failures.
         */
        @Schema(description = "Field-level validation errors (only present on 400 responses)")
        Map<String, String> fieldErrors
) {
    /**
     * Convenience factory for error responses without field errors.
     */
    public static ErrorResponse of(int status, String error, String message,
                                   String path, String traceId) {
        return new ErrorResponse(Instant.now(), status, error, message, path, traceId, null);
    }

    /**
     * Convenience factory for validation error responses with field-level details.
     */
    public static ErrorResponse validationError(String path, String traceId,
                                                Map<String, String> fieldErrors) {
        return new ErrorResponse(Instant.now(), 400, "Bad Request",
                "Validation failed", path, traceId, fieldErrors);
    }
}
