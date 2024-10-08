package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.apply.repository.ApplicationRepository;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.user.service.DeleteApplyPromiseService;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class DeleteApplyPromiseServiceImpl implements DeleteApplyPromiseService {
    private final ApplicationRepository applicationRepository;
    public void execute(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        applicationRepository.delete(application);
    }
}
