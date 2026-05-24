package com.drivingtest.portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Request body for {@code PUT /api/v1/admin/learn/{category}/content/{id}}.
 * <p>
 * Only the editable fields are present: discriminators (category, licenseType,
 * locale, kind, sectionOrder) are fixed at create time. To reorder sections,
 * use the dedicated reorder endpoint.
 */
public record UpdateCategoryContentRequest(
        @NotBlank @Size(max = 200) String title,
        @NotBlank String bodyMarkdown
) {}
