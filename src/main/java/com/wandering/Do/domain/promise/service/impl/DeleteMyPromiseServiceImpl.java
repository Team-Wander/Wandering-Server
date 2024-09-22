package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.exception.NotMatchUserException;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.DeleteMyPromiseService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.exception.UserNotFoundException;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class DeleteMyPromiseServiceImpl implements DeleteMyPromiseService {

    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;

    public void execute(Long id) {
        User user = userUtil.getCurrentUser();

        if (user != promiseRepository.findByUser(user))
            throw new NotMatchUserException();

        promiseRepository.deleteById(id);
    }
}
