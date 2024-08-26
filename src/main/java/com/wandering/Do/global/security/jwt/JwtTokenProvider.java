package com.wandering.Do.global.security.jwt;

import com.wandering.Do.domain.auth.presentation.dto.response.TokenInfo;
import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;
import com.wandering.Do.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.wandering.Do.global.security.filter.JwtFilter.AUTHORIZATION_HEADER;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String AUTHORITIES = "auth";
    private static final String GRANT_TYPE = "Bearer";
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final long ACCESS_TOKEN_TIME = 1000 * 60 * 30L;
    private static final long REFRESH_TOKEN_TIME = 1000L * 60 * 60 * 24 * 7;

    @Value("${jwt.secret}")
    private String secretKey;
    private static Key key;
    private final AuthDetailsService authDetailsService;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenInfo generateToken(UUID userId) {
        return TokenInfo.builder()
                .grantType(GRANT_TYPE)
                .accessToken(generateAccessToken(userId))
                .refreshToken(generateRefreshToken(userId))
                .accessTokenExpiresIn(LocalDateTime.now().plusSeconds(ACCESS_TOKEN_TIME))
                .refreshTokenExpiresIn(LocalDateTime.now().plusSeconds(REFRESH_TOKEN_TIME))
                .build();
    }

    // accessToken 생성
    public String generateAccessToken(UUID uuid) {

        long now = (new Date()).getTime();

        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_TIME);

        return Jwts.builder()
                .setSubject(uuid.toString())
                .claim(AUTHORITIES, "JWT")
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // refreshToken 생성
    public String generateRefreshToken(UUID uuid) {
        long now = (new Date()).getTime();

        Date refreshTokenExpiresIn = new Date(now + REFRESH_TOKEN_TIME);

        return Jwts.builder()
                .setSubject(uuid.toString())
                .claim(AUTHORITIES, "JWT")
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // jwt 토큰을 복호화하여 토큰에 들어있는 정보를 꺼내는 메서드
    public Authentication getAuthentication (String accessToken) {
        Claims claims = parseClaims(accessToken);

        if (claims.get(AUTHORITIES) == null) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }

        UserDetails principal = authDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(principal, "", principal.getAuthorities());
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        } catch (ExpiredJwtException e) {
            throw new CustomException(ErrorCode.EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            throw new CustomException(ErrorCode.INVALID_TOKEN_TYPE);
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public String parseRefreshToken(String refreshToken) {
        if (refreshToken.startsWith(TOKEN_PREFIX)) {
            return refreshToken.replace(TOKEN_PREFIX, "");
        }
        else
            return refreshToken;
    }
}
