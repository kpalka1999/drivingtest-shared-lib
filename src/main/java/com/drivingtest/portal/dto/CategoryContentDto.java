package com.drivingtest.portal.dto;

/**
 * One piece of authored knowledge content for a {@link com.drivingtest.portal.enums.QuestionCategory}.
 * <p>
 * Returned ordered (introduction first, then theory sections by {@code sectionOrder}) from
 * {@code GET /api/v1/learn/{category}/content}. The {@code kind} discriminates between the
 * single introduction and the N theory sections.
 *
 * @param id            primary key of the {@code category_content} row
 * @param kind          {@code INTRO} | {@code SECTION}
 * @param sectionOrder  0 for {@code INTRO}, 1..N for {@code SECTION} ordering
 * @param title         section heading shown above the body and in the table of contents
 * @param bodyMarkdown  GFM markdown rendered by the frontend; raw HTML is stripped client-side
 */
public record CategoryContentDto(
        Long id,
        String kind,
        int sectionOrder,
        String title,
        String bodyMarkdown
) {}
