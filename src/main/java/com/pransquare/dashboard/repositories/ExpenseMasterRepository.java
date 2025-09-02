package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pransquare.dashboard.entities.ExpenseMasterEntity;

public interface ExpenseMasterRepository extends JpaRepository<ExpenseMasterEntity, Integer> {
}
