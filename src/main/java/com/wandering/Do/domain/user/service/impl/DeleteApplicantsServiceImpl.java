package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.apply.repository.ApplicationRepository;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.exception.UserNotMatchException;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.exception.NotIncludedApplicationException;
import com.wandering.Do.domain.user.service.DeleteApplicantsService;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@ServiceWithTransactional
@RequiredArgsConstructor
public class DeleteApplicantsServiceImpl implements DeleteApplicantsService {
    private final PromiseRepository promiseRepository;
    private final ApplicationRepository applicationRepository;
    private final UserUtil userUtil;
    public void execute(Long promiseId, UUID userId) {
        User user = userUtil.getCurrentUser();

        Promise promise = promiseRepository.findById(promiseId)
                .orElseThrow(PromiseNotFoundException::new);

        if (!promise.getUser().getId().equals(user.getId())){
            throw new UserNotMatchException();
        }

        Application application = applicationRepository.findByPromiseIdAndUserId(promiseId, userId)
                .orElseThrow(NotIncludedApplicationException::new);


        if (!application.getUser().getId().equals(userId)) {
            throw new NotIncludedApplicationException();
        }

        applicationRepository.delete(application);
    }
}
