package com.wandering.Do.domain.declare.util.impl;

import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.declare.util.ReportConverter;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.req.ReportPromiseReq;
import com.wandering.Do.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ReportConverterImpl implements ReportConverter {

    public Report toEntity(ReportPromiseReq reportPromiseReq, User user, Promise promise) {
        return Report.builder()
                .reason(reportPromiseReq.getReason())
                .content(reportPromiseReq.getContent())
                .user(user)
                .promise(promise)
                .build();
    }
}
