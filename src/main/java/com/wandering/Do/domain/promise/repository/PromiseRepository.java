package com.wandering.Do.domain.promise.repository;

import com.wandering.Do.domain.promise.entity.Promise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromiseRepository extends JpaRepository<Promise, Long> {
    List<Promise> findBySpot(String spot);
}
