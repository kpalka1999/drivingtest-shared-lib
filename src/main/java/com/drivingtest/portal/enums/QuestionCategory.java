package com.drivingtest.portal.enums;

/**
 * Semantic category of a driving-test question, derived from the block-name prefix
 * in the official question database (column S in baza.xlsx).
 */
public enum QuestionCategory {
    ROAD_RULES,
    ROAD_SIGNS,
    FIRST_AID,
    MANEUVERS,
    SPECIAL_CONDITIONS,
    MOTORCYCLE_SPECIFIC,
    PASSENGER_CAR_SPECIFIC,
    TRUCK_SPECIFIC,
    BUS_SPECIFIC,
    TRACTOR_SPECIFIC,
    SPECIAL_VEHICLE_SPECIFIC,
    ROAD_TRANSPORT_SPECIFIC
}
