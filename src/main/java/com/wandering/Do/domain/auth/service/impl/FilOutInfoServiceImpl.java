package com.wandering.Do.domain.auth.service.impl;

import com.wandering.Do.domain.auth.presentation.dto.request.UserInfoReq;
import com.wandering.Do.domain.auth.service.FilOutInfoService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.exception.UserNotFoundException;
import com.wandering.Do.domain.user.repository.UserRepository;
import com.wandering.Do.domain.user.util.UserUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class FilOutInfoServiceImpl implements FilOutInfoService {

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    public void execute(UserInfoReq userInfoReq) {
        User user = userUtil.getCurrentUser();

        userRepository.findById(user.getId())
                .orElseThrow(UserNotFoundException::new);

        user.filOutInfo(userInfoReq);

        userRepository.save(user);
    }
}
