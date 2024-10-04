package com.wandering.Do.domain.admin.service.impl;

import com.wandering.Do.domain.admin.presentation.dto.req.ChangeUserCase;
import com.wandering.Do.domain.admin.service.ChangeUserCaseService;
import com.wandering.Do.domain.promise.exception.UserNotMatchException;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.exception.UserNotFoundException;
import com.wandering.Do.domain.user.repository.UserRepository;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@ServiceWithTransactional
@RequiredArgsConstructor
public class ChangeUserCaseServiceImpl implements ChangeUserCaseService {

    private final UserUtil userUtil;
    private final UserRepository userRepository;

    public void execute(UUID userId, ChangeUserCase changeUserCase) {
        User user = userUtil.getCurrentUser();

        if (user.getAuthority() != Authority.ADMIN) {
            throw new UserNotMatchException();
        }

        User member = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        member.changeCase(changeUserCase.getChangeCase());
    }
}
