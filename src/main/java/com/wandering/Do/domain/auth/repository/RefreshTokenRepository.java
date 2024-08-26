package com.wandering.Do.domain.auth.repository;

import com.wandering.Do.domain.auth.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
