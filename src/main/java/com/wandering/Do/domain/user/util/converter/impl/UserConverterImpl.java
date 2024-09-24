package com.wandering.Do.domain.user.util.converter.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.presentation.dto.res.GetListRes;
import com.wandering.Do.domain.user.util.converter.UserConverter;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public GetListRes toListDto(Promise promise) {
        return GetListRes.builder()
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
