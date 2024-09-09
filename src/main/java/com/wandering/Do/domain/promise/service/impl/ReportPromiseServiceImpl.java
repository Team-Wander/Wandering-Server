package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.declare.Reason;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.declare.exception.NotEmptyReasonException;
import com.wandering.Do.domain.declare.repository.ReportRepository;
import com.wandering.Do.domain.declare.util.ReportConverter;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.req.ReportPromiseReq;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.ReportPromiseService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportPromiseServiceImpl implements ReportPromiseService {

    private final PromiseRepository promiseRepository;
    private final ReportRepository reportRepository;
    private final UserUtil userUtil;
    private final ReportConverter reportConverter;

    public void execute(ReportPromiseReq reportPromiseReq, Long id) {
        User user = userUtil.getCurrentUser();

        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        if (reportPromiseReq.getReason() == Reason.ETC
            && reportPromiseReq.getContent().isEmpty()) {
            throw new NotEmptyReasonException();
        }

        Report report = reportConverter.toEntity(reportPromiseReq, user, promise);

        reportRepository.save(report);
    }
}
