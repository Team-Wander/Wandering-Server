package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;

import java.util.List;

public interface SearchKeywordService {
    List<PromiseGetListRes> execute(String keyword);
}
