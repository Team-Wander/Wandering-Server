package com.wandering.Do.domain.admin.service.impl;

import com.wandering.Do.domain.admin.exception.PermissionNotAccessibleException;
import com.wandering.Do.domain.admin.presentation.dto.res.UserListRes;
import com.wandering.Do.domain.admin.service.GetUserListService;
import com.wandering.Do.domain.admin.util.AdminConverter;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.repository.UserRepository;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactionalReadOnly;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class GetUserListServiceImpl implements GetUserListService {

    private final UserUtil userUtil;
    private final UserRepository userRepository;
    private final AdminConverter adminConverter;

    public List<UserListRes> execute() {
        User user = userUtil.getCurrentUser();

        if (user.getAuthority() != Authority.ADMIN) {
            throw new PermissionNotAccessibleException();
        }

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(adminConverter::toUserDto)
                .toList();
    }
}
