package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseUpdateReq;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.UpdatePromiseService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.exception.UserNotFoundException;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class UpdatePromiseServiceImpl implements UpdatePromiseService {

    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;

    public void execute(Long id, PromiseUpdateReq updateReqDto) {
        User user = userUtil.getCurrentUser();


        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        if (promise.getUser() != user)
            throw new UserNotFoundException();

        promise.updatePromise(updateReqDto);
    }

}
