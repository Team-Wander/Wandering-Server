package com.wandering.Do.domain.auth.service.impl;

import com.wandering.Do.domain.auth.RefreshToken;
import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;
import com.wandering.Do.domain.auth.repository.RefreshTokenRepository;
import com.wandering.Do.domain.auth.service.SignInService;
import com.wandering.Do.domain.declare.Case;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.repository.UserRepository;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import com.wandering.Do.global.oauth2.dto.NaverInfoRes;
import com.wandering.Do.domain.auth.presentation.dto.request.SignInReq;
import com.wandering.Do.global.oauth2.service.RequestOAuth2InfoService;
import com.wandering.Do.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@ServiceWithTransactional
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final RequestOAuth2InfoService requestOAuth2InfoService;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenInfo execute(SignInReq params) {
        NaverInfoRes info = requestOAuth2InfoService.request(params);
        UUID userId = findOrCreateMember(info);

        TokenInfo tokenInfo = jwtTokenProvider.generateToken(userId);
        saveRefreshToken(tokenInfo.getRefreshToken(), userId);

        return tokenInfo;
    }

    private UUID findOrCreateMember(NaverInfoRes naverInfoRes) {
        return userRepository.findByEmail(naverInfoRes.getEmail())
                .map(User::getId)
                .orElseGet(() -> saveUser(naverInfoRes));
    }

    private UUID saveUser(NaverInfoRes naverInfoRes) {
        User user = User.builder()
                .email(naverInfoRes.getEmail())
                .name(naverInfoRes.getNickname())
                .birthYear(naverInfoRes.getBirthyear())
                .gender(saveGender(naverInfoRes.getGender()))
                .mobile(naverInfoRes.getMobile())
                .authority(Authority.USER)
                .aCase(Case.NORMAL)
                .build();

        userRepository.save(user);

        return user.getId();
    }

    private Gender saveGender(String gender) {
        if (gender.equals("F"))
            return Gender.FEMALE;
        else if (gender.equals("M"))
            return Gender.MALE;
        else return null;
    }

    private void saveRefreshToken(String token, UUID userId) {
        RefreshToken refreshToken = RefreshToken.builder()
                .id(token)
                .userId(userId)
                .build();

        refreshTokenRepository.save(refreshToken);
    }

}
