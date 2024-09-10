package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Application;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.repository.ApplicationRepository;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.ApplyReqService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplyReqServiceImpl implements ApplyReqService {
    private final ApplicationRepository applicationRepository;
    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;
    @Override
    public void execute(Long id) {
        User user = userUtil.getCurrentUser();
        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);
        Application application = new Application(promise, user);

        applicationRepository.save(application);
    }
}
