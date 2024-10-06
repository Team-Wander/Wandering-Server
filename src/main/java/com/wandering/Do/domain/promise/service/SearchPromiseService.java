package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetSearchRes;

import java.util.List;

public interface SearchPromiseService {
    List<PromiseGetSearchRes> execute(String keyword);
}
