package com.wandering.Do.domain.auth.service;

import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;

public interface ReissueTokenService {
    TokenInfo execute(String token);
}
