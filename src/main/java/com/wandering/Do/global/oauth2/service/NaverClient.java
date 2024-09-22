package com.wandering.Do.global.oauth2.service;

import com.wandering.Do.domain.auth.presentation.dto.request.SignInReq;
import com.wandering.Do.global.oauth2.OAuthProvider;
import com.wandering.Do.global.oauth2.dto.NaverInfoRes;
import com.wandering.Do.global.oauth2.dto.NaverTokensRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NaverClient {
    private static final String GRANT_TYPE = "authorization_code";

    @Value("${spring.security.oauth2.client.provider.naver.token-uri}")
    private String authUrl;

    @Value("${spring.security.oauth2.client.provider.naver.user-info-uri}")
    private String apiUrl;

    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    private String clientSecret;

    private final RestTemplate restTemplate;

    public OAuthProvider oAuthProvider() {
        return OAuthProvider.NAVER;
    }

    public String requestAccessToken(SignInReq params) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = params.makeBody();
        body.add("grant_type", GRANT_TYPE);
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);

        HttpEntity<?> request = new HttpEntity<>(body, httpHeaders);

        NaverTokensRes response = restTemplate.postForObject(authUrl, request, NaverTokensRes.class);

        assert response != null;
        return response.getAccessToken();
    }

    public NaverInfoRes requestOauthInfo (String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.set("Authorization", "Bearer " + accessToken);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        HttpEntity<?> request = new HttpEntity<>(body, httpHeaders);

        return restTemplate.postForObject(apiUrl, request, NaverInfoRes.class);
    }
}
