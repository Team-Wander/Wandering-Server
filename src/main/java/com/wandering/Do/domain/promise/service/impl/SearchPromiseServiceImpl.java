package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.SearchPromiseService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchPromiseServiceImpl implements SearchPromiseService {
    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;

    @Override
    public List<PromiseGetListRes> execute(String keyword) {
        List<Promise> listPromise = promiseRepository.findByTitleContaining(keyword);

        return listPromise.stream()
                .map(promiseConverter::toListDto)
                .collect(Collectors.toList());
    }
}
