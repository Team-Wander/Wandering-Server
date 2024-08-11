package com.wandering.Do.domain.auth.presentation;

import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;
import com.wandering.Do.domain.auth.service.SignInService;
import com.wandering.Do.domain.auth.presentation.dto.request.SignInReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SignInService signInService;

    @PostMapping
    public ResponseEntity<TokenInfo> signIn (@RequestBody SignInReq params) {
        return ResponseEntity.ok(signInService.execute(params));
    }
}
