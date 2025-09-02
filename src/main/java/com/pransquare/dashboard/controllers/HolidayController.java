package com.pransquare.dashboard.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.HolidayMasterEntity;
import com.pransquare.dashboard.entities.LeaveTypeEntity;
import com.pransquare.dashboard.models.HolidayModel;
import com.pransquare.dashboard.models.LeaveTypeModel;
import com.pransquare.dashboard.services.HolidayService;

@RestController
@RequestMapping(value = "/Pransquare/MasterConfiguration/holiday")
public class HolidayController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);

    @Autowired
    HolidayService holidayService;

    @PostMapping("/createOrUpdateHoliday")
    public ResponseEntity<HolidayMasterEntity> createOrUpdateHoliday(@RequestBody HolidayModel holidayModel) {
        if (holidayModel == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        try {
            return ResponseEntity.ok(holidayService.createOrUpdateHoliday(holidayModel));
        } catch (Exception e) {
            logger.error("Error creating or updating Holiday: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getAllHolidays")
    public ResponseEntity<List<HolidayMasterEntity>> getAllHolidays(
            @RequestParam(required = false) String workLocation) {
        try {
            return ResponseEntity.ok(holidayService.getAllHolidays(workLocation));
        } catch (Exception e) {
            logger.error("Error getting all Holidays: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}