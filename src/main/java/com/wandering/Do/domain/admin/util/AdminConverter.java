package com.wandering.Do.domain.admin.util;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;

import java.util.List;

public interface AdminConverter {
    ReportListRes toDtoList(Promise promise, Report report);
}
