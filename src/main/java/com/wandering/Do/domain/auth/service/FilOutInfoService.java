package com.wandering.Do.domain.auth.service;

import com.nimbusds.openid.connect.sdk.claims.UserInfo;
import com.wandering.Do.domain.auth.presentation.dto.request.UserInfoReq;

public interface FilOutInfoService {
    void execute(UserInfoReq userInfoReq);
}
