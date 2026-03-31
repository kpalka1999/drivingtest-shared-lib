package com.drivingtest.portal.enums;

/**
 * Type of media asset associated with a question or answer.
 * Inferred from file extension: .wmv → VIDEO, .jpg/.png → IMAGE.
 */
public enum MediaType {
    IMAGE,
    VIDEO,
    AUDIO
}
