package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetBoardService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetBoardServiceImpl implements GetBoardService {

    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;

    @Override
    public PromiseGetRes execute(Long id) {
        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        return promiseConverter.toDto(promise);
    }
}