package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.*;
import com.wandering.Do.domain.promise.exception.InvalidGradeSelectionException;
import com.wandering.Do.domain.promise.exception.InvalidGradesSelectionException;
import com.wandering.Do.domain.promise.exception.InvalidTagCountException;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.WritePromiseService;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import com.wandering.Do.domain.user.entity.Grade;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WritePromiseServiceImpl implements WritePromiseService {

    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;
    private final PromiseConverter promiseConverter;


    @Override
    public void execute(PromiseWriteReq writeReqDto) {

        User user = userUtil.getCurrentUser();

        List<Tag> tags = writeReqDto.getTags();
        if (tags.size() > 2) {
            throw new InvalidTagCountException();
        }

        List<Grade> grades = writeReqDto.getGrade();
        if(grades.contains(Grade.ANY) && grades.size() > 1) {
            throw new InvalidGradeSelectionException();
        }

        boolean hasSpecificGrades = grades.stream().anyMatch(grade -> grade != Grade.ANY);
        if (hasSpecificGrades && grades.contains(Grade.ANY)) {
            throw new InvalidGradesSelectionException();
        }

        Promise promise = promiseConverter.toEntity(writeReqDto, user);

        promiseRepository.save(promise);
    }
}