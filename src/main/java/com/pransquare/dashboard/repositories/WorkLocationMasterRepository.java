package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.WorkLocationMasterEntity;

import java.util.List;

@Repository
public interface WorkLocationMasterRepository extends JpaRepository<WorkLocationMasterEntity, Integer> {
    List<WorkLocationMasterEntity> findByStatus(String status);
}
