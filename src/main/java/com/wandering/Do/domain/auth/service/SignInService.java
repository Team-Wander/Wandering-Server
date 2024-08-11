package com.wandering.Do.domain.auth.service;

import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;
import com.wandering.Do.domain.auth.presentation.dto.request.SignInReq;

public interface SignInService {
    TokenInfo execute(SignInReq oAuth2LoginParams);
}
