package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetPromiseService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetPromiseServiceImpl implements GetPromiseService {

    private final PromiseRepository promiseRepository;
    private final PromiseConverter promiseConverter;

    @Override
    public PromiseGetRes execute(Long id) {
        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        return PromiseGetRes.builder()
                // user info
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                .author_profile(promise.getUser().getImage())
                // promise
                .id(promise.getId())
                .title(promise.getTitle())
                .content(promise.getContent())
                .grade(promise.getGrade())
                .gender(promise.getGender())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();

        return promiseConverter.toDto(promise);

    }
}

        return promiseConverter.toDto(promise);
    }
}

