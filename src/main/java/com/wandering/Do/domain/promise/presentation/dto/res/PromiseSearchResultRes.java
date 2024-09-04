package com.wandering.Do.domain.promise.presentation.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PromiseSearchResultRes {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDate date;
    private Integer maximum;
    private List<String> tags;
}
