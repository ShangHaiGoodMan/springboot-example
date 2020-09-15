package com.cloud.security.config.jpa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * JPA分页 排序封装
 */
public class PageableBuild {

    private static final String DEFAULT_SORT_NAME = "id";

    public static Pageable build(Integer page, Integer size, Sort.Direction direction, String sortName) {
        page = page <= 0 ? 0 : page - 1;
        size = size <= 0 ? 10 : size;
        Sort sort = Sort.by(direction, StringUtils.isEmpty(sortName) ? DEFAULT_SORT_NAME : sortName);
        return PageRequest.of(page, size, sort);
    }
}
