package com.wandering.Do.domain.auth.service.impl;

import com.wandering.Do.domain.auth.RefreshToken;
import com.wandering.Do.domain.auth.exception.ExpiredRefreshTokenException;
import com.wandering.Do.domain.auth.repository.RefreshTokenRepository;
import com.wandering.Do.domain.auth.service.LogoutService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.redis.RedisUtil;
import com.wandering.Do.global.security.jwt.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {

    private final RedisUtil redisUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserUtil userUtil;
    private final JwtTokenProvider jwtTokenProvider;

    public void execute(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization").substring(7);

        User user = userUtil.getCurrentUser();

        RefreshToken validToken = refreshTokenRepository.findByUserId(user.getId())
                .orElseThrow(ExpiredRefreshTokenException::new);

        refreshTokenRepository.delete(validToken);

        redisUtil.setBlackList(accessToken, "accessToken", jwtTokenProvider.getExpiration(accessToken));
    }
}
