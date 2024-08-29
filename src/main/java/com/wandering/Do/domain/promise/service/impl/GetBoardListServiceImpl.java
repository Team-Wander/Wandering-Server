package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetBoardListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GetBoardListServiceImpl implements GetBoardListService {
    private final PromiseRepository promiseRepository;
    @Override
    public List<PromiseGetListRes> execute(String spot) {

        List<Promise> promises = promiseRepository.findBySpot(spot);

        return promises.stream()
                .map(promise -> PromiseGetListRes.toDto(promise))
                .collect(Collectors.toList());
    }
}
