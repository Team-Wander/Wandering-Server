package com.wandering.Do.domain.auth.service.impl;

import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;
import com.wandering.Do.domain.auth.service.SignInService;
import com.wandering.Do.domain.user.entity.Authority;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.repository.UserRepository;
import com.wandering.Do.global.oauth2.dto.NaverInfoRes;
import com.wandering.Do.domain.auth.presentation.dto.request.SignInReq;
import com.wandering.Do.global.oauth2.service.RequestOAuth2InfoService;
import com.wandering.Do.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final RequestOAuth2InfoService requestOAuth2InfoService;


    public TokenInfo execute(SignInReq params) {
        NaverInfoRes info = requestOAuth2InfoService.request(params);
        UUID userId = findOrCreateMember(info);

        return jwtTokenProvider.generateToken(userId);
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
                .gender(naverInfoRes.getGender())
                .mobile(naverInfoRes.getMobile())
                .authority(Authority.USER)
                .build();

        userRepository.save(user);

        return user.getId();
    }

}
