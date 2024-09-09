package com.wandering.Do.domain.admin.util.impl;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;
import org.springframework.stereotype.Component;

@Component
public class AdminConverterImpl implements AdminConverter {

    public ReportListRes toDtoList(Promise promise, Report report) {
        return ReportListRes.builder()
                .id(promise.getId())
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                .reason(report.getReason())
                .title(promise.getTitle())
                .Grade(promise.getGrade())
                .Gender(promise.getGender())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();
    }
}
