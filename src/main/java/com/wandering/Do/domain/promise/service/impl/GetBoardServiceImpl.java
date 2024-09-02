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
                // user info
                .author(promise.getUser().getName())
                .userSchool(promise.getUser().getSchool())
                .userGrade(promise.getUser().getGrade())
                .userGender(promise.getUser().getGender())
                // promise
                .id(promise.getId())
                .title(promise.getTitle())
                .content(promise.getContent())
                .Grade(promise.getGrade())
                .Gender(promise.getGender())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .image(promise.getUser().getImage())
                .build();
    }
}
