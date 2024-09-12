package com.wandering.Do.domain.admin.service.impl;

import com.wandering.Do.domain.admin.exception.NotFoundReportException;
import com.wandering.Do.domain.admin.exception.PermissionNotAccessibleException;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;
import com.wandering.Do.domain.admin.service.GetReportInfoService;
import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.declare.repository.ReportRepository;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class GetReportInfoServiceImpl implements GetReportInfoService {

    private final UserUtil userUtil;
    private final ReportRepository reportRepository;
    private final PromiseRepository promiseRepository;
    private final AdminConverter adminConverter;

    public ReportInfoRes execute(Long id) {
        User user = userUtil.getCurrentUser();

        if (user.getAuthority() != Authority.ADMIN) {
            throw new PermissionNotAccessibleException();
        }

        Report report = reportRepository.findById(id)
                .orElseThrow(NotFoundReportException::new);

        Promise promise = promiseRepository.findById(report.getPromise().getId())
                .orElseThrow(NotFoundReportException::new);

        return adminConverter.toDto(promise, report);
    }
}
