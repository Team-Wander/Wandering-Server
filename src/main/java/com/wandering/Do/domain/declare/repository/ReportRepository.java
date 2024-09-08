package com.wandering.Do.domain.declare.repository;

import com.wandering.Do.domain.declare.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
