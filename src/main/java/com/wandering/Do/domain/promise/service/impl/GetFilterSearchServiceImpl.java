package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.res.FilteredSearch.PromiseResponse;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseSearchResultRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetFilterSearchService;
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
    @Override
    public PromiseResponse execute(List<Tag> tag, List<Gender> gender, List<Grade> grade) {
        List<Promise> promises = promiseRepository.findAll();

        // Tag로 필터링
        if (tag != null && !tag.isEmpty()) {
            promises = promises.stream()
                    .filter(promise -> promise.getTags().stream().anyMatch(tag::contains))
                    .collect(Collectors.toList());
        }

        // Grade로 필터링
        if (grade != null && !grade.isEmpty()) {
            promises = promises.stream()
                    .filter(promise -> grade.contains(promise.getGrade()))
                    .collect(Collectors.toList());
        }

        // Gender로 필터링
        if (gender != null && !gender.isEmpty()) {
            promises = promises.stream()
                    .filter(promise -> gender.contains(promise.getGender()))
                    .collect(Collectors.toList());
        }

        if (promises.isEmpty()) {
            throw new PromiseNotFoundException();
        }

        List<PromiseSearchResultRes> result = promises.stream()
                .map(promise -> PromiseSearchResultRes.builder()
                        .id(promise.getId())
                        .author(promise.getUser().getName())
                        .title(promise.getTitle())
                        .content(promise.getContent())
                        .date(promise.getDate())
                        .maximum(promise.getMaximum())
                        .tags(promise.getTags().stream().map(Tag::name).collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

        long total = result.size();

        return PromiseResponse.builder()
                .total(total)
                .promises(result)
                .build();
    }
}

