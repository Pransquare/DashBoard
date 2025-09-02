package com.pransquare.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.SectionSubsectionConfiguration;
import com.pransquare.dashboard.models.SectionSubsectionInputModel;
import com.pransquare.dashboard.models.TDSInputModel;
import com.pransquare.dashboard.services.SectionSubsectionConfigurationService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration")
public class SectionSubsectionConfigurationController {

    @Autowired
    private SectionSubsectionConfigurationService service;

    // API to get all active configurations
    @GetMapping("/getSectionSubsectionConfig")
    public ResponseEntity<List<SectionSubsectionConfiguration>> getAllActive() {
        List<SectionSubsectionConfiguration> configurations = service.getAllActive();
        return ResponseEntity.ok(configurations);
    }

    // API to create or update a configuration
    @PostMapping("/saveSectionSubsectionConfig")
    public ResponseEntity<List<SectionSubsectionConfiguration>> createOrUpdate(@RequestBody SectionSubsectionInputModel config) {
        List<SectionSubsectionConfiguration> updatedConfig = service.createOrUpdate(config);
        return ResponseEntity.ok(updatedConfig);
    }

    // API to delete a configuration by id
    @DeleteMapping("/deleteSectionSubsectionConfig/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // API to get configurations based on a list of section_code and financial_year_code
    @PostMapping("/getBySectionCodes")
    public ResponseEntity<List<SectionSubsectionConfiguration>> getBySectionCodesAndFinancialYearCodes(
            @RequestBody TDSInputModel tDSInputModel) {
        List<SectionSubsectionConfiguration> configurations = service.getBySectionCodes(tDSInputModel);
        return ResponseEntity.ok(configurations);
    }
    
    @PutMapping("/updateSectionSubsectionConfig")
    public ResponseEntity<SectionSubsectionConfiguration> updateConfiguration(
            @RequestBody SectionSubsectionInputModel inputModel) {
        SectionSubsectionConfiguration updatedConfig = service.updateConfiguration(inputModel);
        return ResponseEntity.ok(updatedConfig);
    }
}
