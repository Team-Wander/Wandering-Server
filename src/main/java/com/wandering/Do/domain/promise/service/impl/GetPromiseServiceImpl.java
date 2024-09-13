package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetPromiseService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class GetPromiseServiceImpl implements GetPromiseService {

    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;

    public PromiseGetRes execute(Long id) {
        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        return promiseConverter.toDto(promise);
    }
}