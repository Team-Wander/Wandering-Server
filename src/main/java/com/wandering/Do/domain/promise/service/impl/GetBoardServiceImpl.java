package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetBoardServiceImpl implements GetBoardService {

    private final PromiseRepository promiseRepository;
    @Override
    public PromiseGetRes execute(Long id) {
        Promise promise = promiseRepository.findById(id).orElseThrow(PromiseNotFoundException::new);

        return PromiseGetRes.builder()
                .id(promise.getId())
                .author(promise.getUser().getName())
                .title(promise.getTitle())
                .content(promise.getContent())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .gender(promise.getGender())
                .grade(promise.getGrade())
                .tag(promise.getTags())
                .image(promise.getUser().getImage()) // 임시 값
                .build();
    }
}
