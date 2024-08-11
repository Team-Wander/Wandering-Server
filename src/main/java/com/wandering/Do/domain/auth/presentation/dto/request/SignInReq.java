package com.wandering.Do.domain.auth.presentation.dto.request;

import com.wandering.Do.global.oauth2.OAuthProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@NoArgsConstructor
public class SignInReq {
    private String authorizationCode;
    private String state;

    public OAuthProvider oAuthProvider() {
        return OAuthProvider.NAVER;
    }

    public MultiValueMap<String, String> makeBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        body.add("state", state);
        return body;
    }
}
