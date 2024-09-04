package com.wandering.Do.domain.promise.presentation.dto.res.FilteredSearch;

import com.wandering.Do.domain.promise.presentation.dto.res.PromiseSearchResultRes;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PromiseResponse {
    private long total;
    private List<PromiseSearchResultRes> promises;
}
