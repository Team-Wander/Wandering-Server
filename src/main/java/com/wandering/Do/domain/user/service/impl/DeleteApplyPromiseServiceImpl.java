package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.apply.repository.ApplicationRepository;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.service.DeleteApplyPromiseService;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class DeleteApplyPromiseServiceImpl implements DeleteApplyPromiseService {
    private final PromiseRepository promiseRepository;
    private final ApplicationRepository applicationRepository;
    private final UserUtil userUtil;
    public void execute(Long promiseId) {
        User user = userUtil.getCurrentUser();
        Promise promise = promiseRepository.findById(promiseId)
                .orElseThrow(PromiseNotFoundException::new);

        Application application = applicationRepository.findByPromiseAndUserId(promise, user.getId())
                .orElseThrow(PromiseNotFoundException::new);

        applicationRepository.delete(application);
    }
}
