package com.wandering.Do.domain.auth;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@Builder
@Getter
@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
public class RefreshToken {
    @Id
    private String id; // refreshToken

    @Indexed
    private UUID userId;

}
