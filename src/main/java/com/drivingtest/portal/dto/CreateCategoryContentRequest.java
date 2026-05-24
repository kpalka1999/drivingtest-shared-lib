package com.drivingtest.portal.dto;

import com.drivingtest.portal.enums.LicenseType;
import com.drivingtest.portal.enums.QuestionCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * Request body for {@code POST /api/v1/admin/learn/{category}/content}.
 * <p>
 * {@code licenseType} is nullable — null means the row applies to every licence
 * for this category (shared content). {@code kind} discriminates between the
 * single {@code INTRO} (per category/licence/locale, {@code sectionOrder=0})
 * and the N {@code SECTION} rows ({@code sectionOrder>=1}).
 */
public record CreateCategoryContentRequest(
        @NotNull QuestionCategory category,
        LicenseType licenseType,
        @NotBlank @Pattern(regexp = "pl|en|de|uk") String locale,
        @NotBlank @Pattern(regexp = "INTRO|SECTION") String kind,
        @PositiveOrZero int sectionOrder,
        @NotBlank @Size(max = 200) String title,
        @NotBlank String bodyMarkdown
) {}
