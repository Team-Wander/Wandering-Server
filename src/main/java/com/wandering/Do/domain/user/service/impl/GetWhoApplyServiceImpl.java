package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.admin.exception.NotFoundReportException;
import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.apply.repository.ApplicationRepository;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.user.presentation.dto.res.GetWhoApplyPromiseRes;
import com.wandering.Do.domain.user.service.GetWhoApplyService;
import com.wandering.Do.domain.user.util.converter.UserConverter;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class GetWhoApplyServiceImpl implements GetWhoApplyService {
    private final ApplicationRepository applicationRepository;
    private final UserConverter userConverter;

    public List<GetWhoApplyPromiseRes> execute(Long promiseId) {
        List<Application> applicationList = applicationRepository.findByPromiseId(promiseId);

        if(applicationList.isEmpty())
            throw new PromiseNotFoundException();

        return applicationList.stream()
                .map(application -> userConverter.toDto(application.getUser()))
                .collect(Collectors.toList());
    }
}
