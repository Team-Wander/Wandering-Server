package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.AlreadyAppliedException;
import com.wandering.Do.domain.promise.exception.IllegalArgumentException;
import com.wandering.Do.domain.promise.exception.LimitExceededException;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.apply.repository.ApplicationRepository;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.ApplyReqService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class ApplyReqServiceImpl implements ApplyReqService {

    private final ApplicationRepository applicationRepository;
    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;

    public void execute(Long id) {
        User user = userUtil.getCurrentUser();

        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

//        if(promise.getUser().getId().equals(user.getId()))
//            throw new IllegalArgumentException();

//        boolean alreadyApplied = applicationRepository.existsByPromiseAndUser(promise, user);
//        if (alreadyApplied) {
//            throw new AlreadyAppliedException();
//        }

        if (promise.getCount() == promise.getMaximum())
            throw new LimitExceededException();
        else promise.increaseCount();
//        if (applicationRepository.existsByPromiseAndUser(promise, user)) {
//            throw new AlreadyAppliedException();
//        } else if (promise.getCount() == promise.getMaximum()) {
//            throw new LimitExceededException();
//        } else promise.increaseCount();

        Application application = new Application(promise, user);

        applicationRepository.save(application);
    }
}
