package com.wandering.Do.domain.declare.util;

import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.req.ReportPromiseReq;
import com.wandering.Do.domain.user.entity.User;

public interface ReportConverter {
    Report toEntity (ReportPromiseReq reportPromiseReq, User user, Promise promise);
}
