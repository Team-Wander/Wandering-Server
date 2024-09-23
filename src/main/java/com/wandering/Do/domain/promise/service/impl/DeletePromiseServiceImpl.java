package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.admin.util.impl.AdminConverterImpl;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.exception.PromiseNotFoundException;
import com.wandering.Do.domain.promise.exception.UserNotMatchException;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.DeletePromiseService;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class DeletePromiseServiceImpl implements DeletePromiseService {

    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;

    public void execute(Long id) {
        User user = userUtil.getCurrentUser();

        Promise promise = promiseRepository.findById(id)
                .orElseThrow(PromiseNotFoundException::new);

        if (user.getAuthority() != Authority.ADMIN && user != promise.getUser())
            throw new UserNotMatchException();

        promiseRepository.deleteById(id);
    }
}
