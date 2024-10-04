package com.wandering.Do.domain.admin.service.impl;

import com.wandering.Do.domain.admin.presentation.dto.res.SearchUserInfoRes;
import com.wandering.Do.domain.admin.service.SearchUserInfoService;
import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.promise.exception.UserNotMatchException;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.repository.UserRepository;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@ServiceWithTransactionalReadOnly
public class SearchUserInfoServiceImpl implements SearchUserInfoService {

    private final UserRepository userRepository;
    private final AdminConverter adminConverter;
    private final UserUtil userUtil;

    public List<SearchUserInfoRes> execute(String name) {
        User user = userUtil.getCurrentUser();

        if (user.getAuthority() != Authority.ADMIN) {
            throw new UserNotMatchException();
        }

        List<User> users = userRepository.findByNameContaining(name);

        return users.stream()
                .map(adminConverter::toSearchUserInfoDto)
                .toList();
    }
}
