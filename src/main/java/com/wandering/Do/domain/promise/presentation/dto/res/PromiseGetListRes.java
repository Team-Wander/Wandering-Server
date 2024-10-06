package com.wandering.Do.domain.promise.presentation.dto.res;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PromiseGetListRes {
    private String author;
    private Long id;
    private String title;
}
