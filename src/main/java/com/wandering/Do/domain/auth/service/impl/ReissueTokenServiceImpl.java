package com.wandering.Do.domain.auth.service.impl;

import com.wandering.Do.domain.auth.RefreshToken;
import com.wandering.Do.domain.auth.exception.ExpiredRefreshTokenException;
import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;
import com.wandering.Do.domain.auth.repository.RefreshTokenRepository;
import com.wandering.Do.domain.auth.service.ReissueTokenService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.exception.UserNotFoundException;
import com.wandering.Do.domain.user.repository.UserRepository;
import com.wandering.Do.global.security.jwt.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ReissueTokenServiceImpl implements ReissueTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public TokenInfo execute(String token) {
        String reissueToken = jwtTokenProvider.parseRefreshToken(token);

        RefreshToken refreshToken = refreshTokenRepository.findById(reissueToken)
                .orElseThrow(ExpiredRefreshTokenException::new);

        User user = userRepository.findById(refreshToken.getUserId())
                .orElseThrow(UserNotFoundException::new);

        TokenInfo tokenInfo = jwtTokenProvider.generateToken(user.getId());

        refreshTokenRepository.deleteById(reissueToken);
        saveRefreshToken(tokenInfo.getRefreshToken(), user.getId());

        return tokenInfo;
    }

    private void saveRefreshToken(String token, UUID userId) {
        RefreshToken refreshToke = RefreshToken.builder()
                .id(token)
                .userId(userId)
                .build();

        refreshTokenRepository.save(refreshToke);
    }
}
