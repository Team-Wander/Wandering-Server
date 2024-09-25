package com.wandering.Do.domain.declare.repository;

import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findByPromiseIdAndUserId(Long promiseId, UUID userId);
}
