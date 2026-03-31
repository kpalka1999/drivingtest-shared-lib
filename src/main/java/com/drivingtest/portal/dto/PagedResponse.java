package com.drivingtest.portal.dto;

import java.util.List;

/**
 * Generic wrapper for paginated list responses.
 *
 * @param <T> the element type
 */
public record PagedResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean last
) {}
