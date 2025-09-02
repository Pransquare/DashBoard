package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.DepartmentMasterEntity;

@Repository
public interface DepartmentMasterRepository extends JpaRepository<DepartmentMasterEntity, Integer> {
    DepartmentMasterEntity findByDepartmentCode(String departmentCode);

    List<DepartmentMasterEntity> findAllByStatusNot(String status);

    DepartmentMasterEntity findByDepartmentCodeAndStatusNot(String departmentCode, String status);
}