package com.pransquare.dashboard.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.DepartmentMasterEntity;
import com.pransquare.dashboard.models.DepartmentModel;
import com.pransquare.dashboard.repositories.DepartmentMasterRepository;
import com.pransquare.dashboard.utils.IntegerUtils;

@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentMasterRepository departmentMasterRepository;

    public List<DepartmentMasterEntity> getAllDepartments() {
        try {
            logger.info("Retrieving all departments");
            return departmentMasterRepository.findAllByStatusNot("deleted");
        } catch (Exception e) {
            logger.error("Error retrieving all departments", e);
            throw new RuntimeException("Error retrieving all departments", e);
        }
    }

    public DepartmentMasterEntity dedupeCheckWithDepartmentCode(String departmentCode) {
        try {
            logger.info("Checking for duplicate department code: {}", departmentCode);
            return departmentMasterRepository.findByDepartmentCodeAndStatusNot(departmentCode, "deleted");
        } catch (Exception e) {
            logger.error("Error checking for duplicate department code", e);
            throw new RuntimeException("Error checking for duplicate department code", e);
        }
    }

    public DepartmentMasterEntity createOrUpdateDepartment(DepartmentModel departmentMasterModel) {
        try {
            DepartmentMasterEntity departmentMasterEntity;
            if (!IntegerUtils.isNotNull(departmentMasterModel.getDepartmentMasterId())) {
                logger.info("Creating new department");
                departmentMasterEntity = new DepartmentMasterEntity();
                departmentMasterEntity.setStatus("active");
                departmentMasterEntity.setCreatedBy(departmentMasterModel.getUser());
                departmentMasterEntity.setCreatedDate(LocalDateTime.now());
            } else {
                Optional<DepartmentMasterEntity> existingEntity = departmentMasterRepository
                        .findById(departmentMasterModel.getDepartmentMasterId());
                departmentMasterEntity = existingEntity.orElseThrow(() -> new IllegalArgumentException(
                        "Department with ID " + departmentMasterModel.getDepartmentMasterId() + " not found"));
                logger.info("Updating department with ID: {}", departmentMasterModel.getDepartmentMasterId());
                departmentMasterEntity.setModifiedBy(departmentMasterModel.getUser());
                departmentMasterEntity.setModifiedDate(LocalDateTime.now());
            }
            departmentMasterEntity.setDepartmentCode(departmentMasterModel.getDepartmentCode());
            departmentMasterEntity.setDepartmentDescription(departmentMasterModel.getDepartmentDescription());
            departmentMasterEntity.setStatus(departmentMasterModel.getStatus());
            return departmentMasterRepository.save(departmentMasterEntity);
        } catch (Exception e) {
            logger.error("Error creating or updating department", e);
            throw new RuntimeException("Error creating or updating department", e);
        }
    }

    public DepartmentMasterEntity deleteDepartment(Integer departmentMasterId) {
        try {
            if (!IntegerUtils.isNotNull(departmentMasterId)) {
                throw new IllegalArgumentException("Department ID cannot be null");
            }
            DepartmentMasterEntity departmentMasterEntity = departmentMasterRepository.findById(departmentMasterId)
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Department with ID " + departmentMasterId + " not found"));
            logger.info("Deleting department with ID: {}", departmentMasterId);
            departmentMasterEntity.setStatus("deleted");
            return departmentMasterRepository.save(departmentMasterEntity);
        } catch (Exception e) {
            logger.error("Error deleting department", e);
            throw new RuntimeException("Error deleting department", e);
        }
    }
}