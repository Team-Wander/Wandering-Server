package com.wandering.Do.domain.promise.repository;

import com.wandering.Do.domain.promise.entity.Promise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromiseRepository extends JpaRepository<Promise, Long> {
}
