package com.drivingtest.portal.enums;

/**
 * Polish driving-licence category codes as defined by national law.
 * PT is a provisional/test category present in the source database.
 *
 * <p>Trailer variants C1E, DE, D1E were absent from the original enum
 * and have been added to match the full official category list.
 */
public enum LicenseType {
    A, A1, A2, AM,
    B, B1, BE,
    C, C1, CE, C1E,
    D, D1, DE, D1E,
    T, PT
}
