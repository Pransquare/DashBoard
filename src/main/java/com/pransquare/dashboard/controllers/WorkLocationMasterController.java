package com.pransquare.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pransquare.dashboard.entities.WorkLocationMasterEntity;
import com.pransquare.dashboard.services.WorkLocationMasterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/workLocation")
public class WorkLocationMasterController {

    private final WorkLocationMasterService workLocationMasterService;

    @Autowired
    public WorkLocationMasterController(WorkLocationMasterService workLocationMasterService) {
        this.workLocationMasterService = workLocationMasterService;
    }

    // Get all work locations
    @GetMapping
    public ResponseEntity<List<WorkLocationMasterEntity>> getAllWorkLocations() {
        List<WorkLocationMasterEntity> workLocations = workLocationMasterService.findAll();
        if (workLocations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workLocations);
    }

    // Get work location by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkLocationMasterEntity> getWorkLocationById(@PathVariable Integer id) {
        Optional<WorkLocationMasterEntity> workLocation = workLocationMasterService.findById(id);
        return workLocation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get work locations by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<WorkLocationMasterEntity>> getWorkLocationsByStatus(@PathVariable String status) {
        List<WorkLocationMasterEntity> workLocations = workLocationMasterService.findByStatus(status);
        if (workLocations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workLocations);
    }

    // Create or update a work location
    @PostMapping
    public ResponseEntity<WorkLocationMasterEntity> createOrUpdateWorkLocation(
            @RequestBody WorkLocationMasterEntity workLocation) {
        WorkLocationMasterEntity savedWorkLocation = workLocationMasterService.saveWorkLocation(workLocation);
        return ResponseEntity.ok(savedWorkLocation);
    }

    // Delete a work location
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkLocation(@PathVariable Integer id) {
        workLocationMasterService.deleteWorkLocation(id);
        return ResponseEntity.noContent().build();
    }
}
