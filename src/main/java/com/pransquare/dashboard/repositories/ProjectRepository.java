package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

    List<ProjectEntity> findAllByStatusNot(String status);

    ProjectEntity findByProjectCodeAndStatusNot(String projectCode, String status);

    // Additional custom queries or methods here if needed
}