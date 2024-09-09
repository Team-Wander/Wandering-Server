package com.wandering.Do.domain.admin.util.impl;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;
import org.springframework.stereotype.Component;

@Component
public class AdminConverterImpl implements AdminConverter {
    @Override
    public ReportListRes toListDto(Promise promise, Report report) {
        return null;
    }
}
