package com.wandering.Do.domain.admin.service;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;

import java.util.List;

public interface GetReportListService {
    List<ReportListRes> execute();
}
