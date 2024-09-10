package com.wandering.Do.domain.admin.service;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;

public interface GetReportInfoService {
    ReportInfoRes execute(Long id);
}
