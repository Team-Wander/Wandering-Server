package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.presentation.dto.res.GetListRes;
import com.wandering.Do.domain.user.service.getMyPromiseService;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.domain.user.util.converter.UserConverter;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class getMyPromiseServiceImpl implements getMyPromiseService {
    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;
    private final UserConverter userConverter;
    @Override
    public List<GetListRes> execute() {
        User user = userUtil.getCurrentUser();
        List<Promise> promises = promiseRepository.findByUser(user);

        return promises.stream()
                .map(userConverter::toListDto)
                .collect(Collectors.toList());
    }
}
