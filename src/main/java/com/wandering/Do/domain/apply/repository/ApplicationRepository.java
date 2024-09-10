package com.wandering.Do.domain.apply.repository;

import com.wandering.Do.domain.apply.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
