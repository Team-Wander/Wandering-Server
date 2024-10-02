package com.wandering.Do.domain.admin.util.impl;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.presentation.dto.res.UserListRes;
import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AdminConverterImpl implements AdminConverter {

    public ReportListRes toListDto(Promise promise, Report report) {
        return  ReportListRes.builder()
                .id(promise.getId())
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                .reason(report.getReason())
                .title(promise.getTitle())
                .grade(promise.getGrade())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();
    }

    public ReportInfoRes toDto(Promise promise, Report report) {
        return ReportInfoRes.builder()
                .id(promise.getId())
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                .reason(report.getReason())
                .content(report.getContent())
                .title(promise.getTitle())
                .grade(promise.getGrade())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .contact(promise.getContact())
                .spot(promise.getSpot())
                .build();
    }

    public UserListRes toUserDto(User user) {
        return UserListRes.builder()
                .userId(user.getId())
                .name(user.getName())
                .school(user.getSchool())
                .gender(user.getGender())
                .profile(user.getImage())
                .aCase(user.getACase())
                .build();
    }
}
