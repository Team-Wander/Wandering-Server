package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetPromiseListService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@ServiceWithTransactionalReadOnly
public class GetPromiseListServiceImpl implements GetPromiseListService {
    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;
    @Override
    public List<PromiseGetListRes> execute(String spot) {

        List<Promise> promises = promiseRepository.findBySpot(spot);

        return promises.stream()
                .map(promiseConverter::toListDto)
                .collect(Collectors.toList());
    }
}
