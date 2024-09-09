package com.wandering.Do.domain.admin.service.impl;

import com.wandering.Do.domain.admin.exception.PermissionNotAccessibleException;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.service.GetReportListService;
import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.declare.repository.ReportRepository;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GetReportListServiceImpl implements GetReportListService {

    private final ReportRepository reportRepository;
    private final UserUtil userUtil;
    private final PromiseRepository promiseRepository;
    private final AdminConverter adminConverter;

    public List<ReportListRes> execute() {
        User user = userUtil.getCurrentUser();

        if (user.getAuthority() != Authority.ADMIN) {
            throw new PermissionNotAccessibleException();
        }

        List<Report> reports = reportRepository.findAll();
        List<ReportListRes> resList = new ArrayList<>();

        for (Report report : reports) {
            Promise promise = promiseRepository.findById(report.getPromise().getId())
                    .orElseThrow(PromiseNotFoundException::new);
            ReportListRes res = adminConverter.toListDto(promise, report);

            resList.add(res);
        }

        return resList;
    }
}
