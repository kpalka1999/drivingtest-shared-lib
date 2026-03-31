package com.drivingtest.portal.exception;

import com.drivingtest.portal.enums.DifficultyLevel;
import com.drivingtest.portal.enums.LicenseType;

/**
 * Thrown when the question pool does not contain enough questions of a given tier
 * to satisfy the exam drawing requirements.
 * Maps to HTTP 503 so callers know the data layer is not ready, not that the
 * request itself is invalid.
 */
public class InsufficientQuestionsException extends RuntimeException {

    public InsufficientQuestionsException(DifficultyLevel difficulty,
                                          LicenseType licenseType,
                                          int pointValue,
                                          int required,
                                          int available) {
        super(String.format(
                "Insufficient questions: need %d × %s/%s pointValue=%d, only %d available",
                required, difficulty, licenseType, pointValue, available));
    }
}
