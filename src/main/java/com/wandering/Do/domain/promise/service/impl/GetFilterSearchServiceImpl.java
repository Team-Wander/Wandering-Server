package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.res.FilteredSearch.PromiseResponse;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetFilterSearchService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GetFilterSearchServiceImpl implements GetFilterSearchService {
    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;
    @Override
    public PromiseResponse execute(List<Tag> tag, List<Gender> gender, List<Grade> grade) {
        List<Promise> promises = promiseRepository.findByTagsInAndGenderInAndGradeIn(tag, gender, grade);

        if (promises.isEmpty()) {
            throw new PromiseNotFoundException();
        }

        List<PromiseGetListRes> result = promises.stream()
                    .map(promiseConverter::toListDto)
                    .collect(Collectors.toList());

        long total = result.size();

        return PromiseResponse.builder()
                .total(total)
                .promises(result)
                .build();
    }
}

