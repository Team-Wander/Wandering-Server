package com.wandering.Do.domain.admin.util;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;

public interface AdminConverter {
    ReportListRes toListDto(Promise promise, Report report);

    ReportInfoRes toDto (Promise promise, Report report);
}
