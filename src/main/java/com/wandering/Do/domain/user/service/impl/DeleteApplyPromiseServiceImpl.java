package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.apply.repository.ApplicationRepository;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.exception.UserNotMatchException;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.service.DeleteApplyPromiseService;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class DeleteApplyPromiseServiceImpl implements DeleteApplyPromiseService {
    private final ApplicationRepository applicationRepository;
    private final UserUtil userUtil;
    public void execute(Long id) {
        User user = userUtil.getCurrentUser();

        Application application = applicationRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        if(!application.getUser().getId().equals(user.getId()))
            throw new UserNotMatchException();

        applicationRepository.delete(application);
    }
}
