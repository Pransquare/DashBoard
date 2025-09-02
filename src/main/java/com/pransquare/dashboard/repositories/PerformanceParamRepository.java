package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.PerformanceParametersEntity;

@Repository
public interface PerformanceParamRepository extends JpaRepository<PerformanceParametersEntity, Long> {

}
