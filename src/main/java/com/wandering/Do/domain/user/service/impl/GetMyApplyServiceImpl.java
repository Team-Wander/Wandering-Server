package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.apply.repository.ApplicationRepository;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;
import com.wandering.Do.domain.user.service.GetMyApplyService;
import com.wandering.Do.domain.user.service.GetMyPromiseService;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.domain.user.util.converter.UserConverter;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class GetMyApplyServiceImpl implements GetMyApplyService {

    private final ApplicationRepository applicationRepository;
    private final UserUtil userUtil;
    private final UserConverter userConverter;

    public List<GetUserPromiseListRes> execute() {
        User user = userUtil.getCurrentUser();
        List<Application> applications = applicationRepository.findByUser(user);

        return applications.stream()
                .map(Application::getPromise)
                .map(userConverter::toListDto)
                .collect(Collectors.toList());
    }
}
