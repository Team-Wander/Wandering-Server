package com.wandering.Do.domain.auth.presentation;

import com.wandering.Do.domain.auth.presentation.dto.request.UserInfoReq;
import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;
import com.wandering.Do.domain.auth.service.FilOutInfoService;
import com.wandering.Do.domain.auth.service.LogoutService;
import com.wandering.Do.domain.auth.service.ReissueTokenService;
import com.wandering.Do.domain.auth.service.SignInService;
import com.wandering.Do.domain.auth.presentation.dto.request.SignInReq;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SignInService signInService;
    private final ReissueTokenService reissueTokenService;
    private final LogoutService logoutService;
    private final FilOutInfoService filOutInfoService;

    @PostMapping
    public ResponseEntity<TokenInfo> signIn (@RequestBody SignInReq params) {
        return ResponseEntity.ok(signInService.execute(params));
    }

    @PatchMapping
    public ResponseEntity<TokenInfo> reissueToken (@RequestHeader String refreshToken) {
        return ResponseEntity.ok(reissueTokenService.execute(refreshToken));
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        logoutService.execute(request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/info")
    public ResponseEntity<Void> filOutInfo(@RequestBody UserInfoReq userInfoReq) {
        filOutInfoService.execute(userInfoReq);
        return ResponseEntity.ok().build();
    }
}
