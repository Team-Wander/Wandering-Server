package com.wandering.Do.domain.admin.service.impl;

import com.wandering.Do.domain.admin.exception.NotFoundReportException;
import com.wandering.Do.domain.admin.service.DeleteReportService;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.declare.repository.ReportRepository;
import com.wandering.Do.domain.promise.exception.UserNotMatchException;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class DeleteReportServiceImpl implements DeleteReportService {

    private final PromiseRepository promiseRepository;
    private final ReportRepository reportRepository;
    private final UserUtil userUtil;

    public void execute(Long dec_id) {
        User user = userUtil.getCurrentUser();
        if (user.getAuthority() != Authority.ADMIN) {
            throw new UserNotMatchException();
        }

        Report report = reportRepository.findById(dec_id)
                .orElseThrow(NotFoundReportException::new);

        promiseRepository.deleteById(report.getPromiseId());
        reportRepository.deleteById(dec_id);
    }
}
