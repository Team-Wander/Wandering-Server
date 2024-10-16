package com.wandering.Do.domain.apply.repository;

import com.wandering.Do.domain.apply.entity.Application;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByUser(User user);
    boolean existsByPromiseAndUser(Promise promise, User user);
    List<Application> findByPromiseId(Long promiseId);
    Optional<Application> findByPromiseAndUserId(Promise promise, UUID userId);
}
