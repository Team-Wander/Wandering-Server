package com.wandering.Do.domain.user.util.converter.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;
import com.wandering.Do.domain.user.util.converter.UserConverter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public GetUserPromiseListRes toListDto(Promise promise) {
        return GetUserPromiseListRes.builder()
                //user info
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                // promise
                .id(promise.getId())
                .title(promise.getTitle())
                .grade(promise.getGrade())
                .gender(promise.getGender())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();
    }
}
