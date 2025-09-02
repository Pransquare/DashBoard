package com.pransquare.dashboard.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pransquare.dashboard.entities.LeaveTypeEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.LeaveTypeModel;
import com.pransquare.dashboard.services.LeaveTypeService;
import com.pransquare.dashboard.utils.IntegerUtils;

import java.util.List;

@RestController
@RequestMapping(value = "/Pransquare/MasterConfiguration/leaveType")
public class LeaveTypeController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);

    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping("/getAllLeaveTypes")
    public ResponseEntity<List<LeaveTypeEntity>> getAllLeaveTypes() {
        try {
            return ResponseEntity.ok(leaveTypeService.getAllLeaveTypes());
        } catch (Exception e) {
            logger.error("Error getting all leave types: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/dedupeCheck/{leaveTypeCode}")
    public ResponseEntity<LeaveTypeEntity> dedupeCheckWithLeaveTypeCode(@PathVariable String leaveTypeCode) {
        if (leaveTypeCode == null || leaveTypeCode.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        try {
            return ResponseEntity.ok(leaveTypeService.dedupeCheckWithLeaveTypeCode(leaveTypeCode));
        } catch (Exception e) {
            logger.error("Error checking dedupe for leave type code: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/createOrUpdateLeaveType")
    public ResponseEntity<LeaveTypeEntity> createOrUpdateLeaveType(@RequestBody LeaveTypeModel leaveType) {
        if (leaveType == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        try {
            return ResponseEntity.ok(leaveTypeService.createOrUpdateLeaveType(leaveType));
        } catch (Exception e) {
            logger.error("Error creating or updating leave type: ", e);
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/deleteLeaveType/{leaveTypeId}")
    public ResponseEntity<LeaveTypeEntity> deleteLeaveType(@PathVariable Integer leaveTypeId) {
        if (!IntegerUtils.isNotNull(leaveTypeId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            return ResponseEntity.ok(leaveTypeService.deleteLeaveType(leaveTypeId));
        } catch (Exception e) {
            logger.error("Error deleting leave type: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}