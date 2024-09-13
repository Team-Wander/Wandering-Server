package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.promise.exception.InvalidGradeSelectionException;
import com.wandering.Do.domain.promise.exception.InvalidGradesSelectionException;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseFilterSearchRes;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetFilterSearchService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ServiceWithTransactionalReadOnly
public class GetFilterSearchServiceImpl implements GetFilterSearchService {

    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;

    public PromiseFilterSearchRes execute(List<Tag> tag, List<Gender> gender, List<Grade> grade) {
        validateGradeSelection(grade);

        List<Promise> promises = promiseRepository.findByTagsInAndGenderInAndGradeIn(tag, gender, grade);

        List<PromiseGetListRes> result = promises.stream()
                    .map(promiseConverter::toListDto)
                    .collect(Collectors.toList());

        return PromiseFilterSearchRes.builder()
                .promises(result)
                .build();
    }

    private void validateGradeSelection(List<Grade> grades) {
        if(grades.contains(Grade.ANY) && grades.size() > 1) {
            throw new InvalidGradeSelectionException();
        }

        boolean hasSpecificGrades = grades.stream().anyMatch(grade -> grade != Grade.ANY);
        if (hasSpecificGrades && grades.contains(Grade.ANY)) {
            throw new InvalidGradesSelectionException();
        }
    }
}

