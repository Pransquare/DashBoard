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

import com.pransquare.dashboard.entities.DesignationEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.DesignationModel;
import com.pransquare.dashboard.services.DesignationService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/designations")
public class DesignationController {

	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);

	@Autowired
	private DesignationService designationService;

	@GetMapping("/getAllDesignations")
	public ResponseEntity<List<DesignationEntity>> getAllDesignations() {
		List<DesignationEntity> designations = designationService.getAllDesignations();
		return new ResponseEntity<>(designations, HttpStatus.OK);
	}

	@GetMapping("/dedupeCheck/{designationCode}")
	public ResponseEntity<DesignationEntity> dedupeCheckWithDesignationCode(@PathVariable String designationCode) {
		if (designationCode == null || designationCode.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		try {
			return ResponseEntity.ok(designationService.dedupeCheckWithDesignationCode(designationCode));
		} catch (Exception e) {
			logger.error("Error checking dedupe for leave type code: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/createOrUpdateDesignation")
	public ResponseEntity<DesignationEntity> createOrUpdateDesignation(@RequestBody DesignationModel designationModel) {
		if (designationModel == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		try {
			return ResponseEntity.ok(designationService.createOrUpdateDesignation(designationModel));
		} catch (Exception e) {
			logger.error("Error creating or updating leave type: ", e);
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	@PostMapping("/deleteDesignation/{designationMasterId}")
	public ResponseEntity<Void> deleteDesignation(@PathVariable Integer designationMasterId) {
		designationService.deleteDesignation(designationMasterId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getDesignation/{designationCode}")
	public ResponseEntity<String> getDesignation(@PathVariable String designationCode) {
		if (designationCode == null || designationCode.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		try {
			return ResponseEntity.ok(designationService.getDesignation(designationCode));
		} catch (Exception e) {
			logger.error("Error checking dedupe for leave type code: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}