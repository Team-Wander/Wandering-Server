package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetSearchRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.SearchPromiseService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@ServiceWithTransactional
@RequiredArgsConstructor
public class SearchPromiseServiceImpl implements SearchPromiseService {

    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;

    public List<PromiseGetSearchRes> execute(String keyword) {
        List<Promise> listPromise = promiseRepository.findByTitleContaining(keyword);

        return listPromise.stream()
                .map(promiseConverter::toDtoSearch)
                .collect(Collectors.toList());
    }
}
