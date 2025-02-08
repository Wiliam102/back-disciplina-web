package com.br.ifba.task.infraestructure.dto;
import java.util.List;

import org.springframework.data.domain.Page;

public record PageDto<T>(
    List<T> content,
    int pageNumber,
    int pageSize,
    long totalElements,
    int totalPages
) {
    public static <T> PageDto<T> from(Page<T> page) {
        return new PageDto<>(
            page.getContent(),
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages()
        );
    }

}
