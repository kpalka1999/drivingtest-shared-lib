package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Request body for {@code POST /api/v1/learn/{category}/view}.
 * <p>
 * The frontend posts one of these every time the user advances past an item in
 * the knowledge journey (introduction, theory section, or question). Idempotent
 * on the server side — re-posting an already-viewed item is a no-op.
 *
 * @param licenseType the licence the user is studying under (drives view-row partitioning)
 * @param targetKind  {@code INTRO} | {@code SECTION} | {@code QUESTION}
 * @param targetId    {@code category_content.id} for INTRO/SECTION, {@code questions.id} for QUESTION
 */
public record MarkViewedRequest(
        @NotNull LicenseType licenseType,
        @NotBlank @Pattern(regexp = "INTRO|SECTION|QUESTION") String targetKind,
        @NotNull Long targetId
) {}
