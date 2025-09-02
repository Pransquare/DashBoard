package com.pransquare.dashboard.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.DepartmentMasterEntity;
import com.pransquare.dashboard.models.DepartmentModel;
import com.pransquare.dashboard.services.DepartmentService;
import com.pransquare.dashboard.utils.IntegerUtils;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/departments")
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getAllDepartments")
    public List<DepartmentMasterEntity> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/dedupeCheckWithDepartmentCode/{departmentCode}")
    public DepartmentMasterEntity dedupeCheckWithDepartmentCode(@PathVariable String departmentCode) {
        return departmentService.dedupeCheckWithDepartmentCode(departmentCode);
    }

    @PostMapping("/createOrUpdateDepartment")
    public ResponseEntity<DepartmentMasterEntity> createDepartment(@RequestBody DepartmentModel departmentMasterModel) {
        if (departmentMasterModel == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        try {
            return ResponseEntity.ok(departmentService.createOrUpdateDepartment(departmentMasterModel));
        } catch (Exception e) {
            logger.error("Error creating or updating Department: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/deleteDepartment/{departmentMasterId}")
    public ResponseEntity<DepartmentMasterEntity> deleteDepartment(@PathVariable Integer departmentMasterId) {
        if (!IntegerUtils.isNotNull(departmentMasterId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            return ResponseEntity.ok(departmentService.deleteDepartment(departmentMasterId));
        } catch (Exception e) {
            logger.error("Error deleting leave type: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}