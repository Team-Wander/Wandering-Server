package com.wandering.Do.domain.user.util.converter.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;
import com.wandering.Do.domain.user.presentation.dto.res.GetWhoApplyPromiseRes;
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

    @Override
    public GetWhoApplyPromiseRes toDto(User user) {
        return GetWhoApplyPromiseRes.builder()
                .user_id(user.getId())
                .user_name(user.getName())
                .user_school(user.getSchool())
                .user_gender(user.getGender())
                .user_grade(user.getGrade())
                .image(user.getImage())
                .build();
    }
}
