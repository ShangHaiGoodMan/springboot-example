package com.cloud.security.dto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageResponse<T> {

    private int current;

    private int total;

    private List<T> rows;
}
