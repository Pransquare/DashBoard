package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.GoalEntity;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, Integer> {
    // Custom query methods can be added here if needed
}
