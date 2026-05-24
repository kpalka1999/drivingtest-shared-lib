package com.drivingtest.portal.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

/**
 * Request body for {@code PUT /api/v1/admin/learn/{category}/content/reorder}.
 * <p>
 * Bulk-updates {@code sectionOrder} on the listed rows. The server validates that
 * (1) every id belongs to the same category, and (2) the resulting orders are
 * unique within each {@code (licenseType, locale, kind)} bucket.
 */
public record ReorderSectionsRequest(
        @NotEmpty @Valid List<SectionOrderEntry> entries
) {
    public record SectionOrderEntry(
            @NotNull Long id,
            @PositiveOrZero int sectionOrder
    ) {}
}
