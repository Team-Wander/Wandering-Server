package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.req.ReportPromiseReq;

public interface ReportPromiseService {
    void execute(ReportPromiseReq reportPromiseReq, Long id);
}
