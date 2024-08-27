package com.wandering.Do.domain.auth.repository;

import com.wandering.Do.domain.auth.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByUserId(UUID userId);
}
