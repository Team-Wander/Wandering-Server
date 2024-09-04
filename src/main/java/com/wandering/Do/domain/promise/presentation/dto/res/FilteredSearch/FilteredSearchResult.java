package com.wandering.Do.domain.promise.presentation.dto.res.FilteredSearch;

import com.wandering.Do.domain.promise.presentation.dto.res.PromiseSearchResultRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class FilteredSearchResult {
    private long total;
    private final List<PromiseSearchResultRes> result;
}
