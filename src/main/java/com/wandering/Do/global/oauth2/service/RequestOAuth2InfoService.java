package com.wandering.Do.global.oauth2.service;

import com.wandering.Do.domain.auth.presentation.dto.request.SignInReq;
import com.wandering.Do.global.oauth2.OAuthProvider;
import com.wandering.Do.global.oauth2.dto.NaverInfoRes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RequestOAuth2InfoService {
    private final Map<OAuthProvider, NaverClient> clients;


    public RequestOAuth2InfoService(List<NaverClient> clients) {
        this.clients = clients.stream().collect(
                Collectors.toUnmodifiableMap(NaverClient::oAuthProvider, Function.identity())
        );
    }

    public NaverInfoRes request (SignInReq params) {
        NaverClient client = clients.get(params.oAuthProvider());
        String accessToken = client.requestAccessToken(params);
        return client.requestOauthInfo(accessToken);
    }
}