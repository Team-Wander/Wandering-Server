package com.wandering.Do.domain.promise.repository;

import com.wandering.Do.domain.promise.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByPromiseId(Long promiseId);
    List<Application> findByUserId(UUID user_id);
}
