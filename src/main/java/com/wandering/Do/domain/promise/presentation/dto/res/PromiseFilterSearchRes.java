package com.wandering.Do.domain.promise.presentation.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PromiseFilterSearchRes {
    private List<PromiseGetListRes> promises;
}
