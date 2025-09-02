package com.pransquare.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.FinancialYearRegimeSectionConfig;
import com.pransquare.dashboard.models.FinancialYearRegimeSectionConfigModel;
import com.pransquare.dashboard.services.FinancialYearRegimeSectionConfigService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration")
public class FinancialYearRegimeSectionConfigController {

    @Autowired
    private FinancialYearRegimeSectionConfigService service;

    @GetMapping("/getFinancialyearRegimeSectionConfig")
    public ResponseEntity<List<FinancialYearRegimeSectionConfig>> getAllActive() {
        List<FinancialYearRegimeSectionConfig> configs = service.getAllActive();
        return ResponseEntity.ok(configs);
    }

    @PostMapping("/saveFinancialyearRegimeSectionConfig")
    public ResponseEntity<List<FinancialYearRegimeSectionConfig> > createOrUpdate(@RequestBody FinancialYearRegimeSectionConfigModel config) {
        List<FinancialYearRegimeSectionConfig> updatedConfig = service.createOrUpdate(config);
        return ResponseEntity.ok(updatedConfig);
    }

    @DeleteMapping("/deleteFinancialyearRegimeSectionConfig/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        
        return ResponseEntity.ok(service.delete(id));
    }
    
    @DeleteMapping("/deleteByFinancialYearCodeAndRegimeCode")
    public ResponseEntity<String> deleteByFinancialYearCodeAndRegimeCode(@RequestParam String financialYearCode, @RequestParam String regimeCode) {
        boolean isDeleted = service.deleteByFinancialYearCodeAndRegimeCode(financialYearCode, regimeCode);
        if (isDeleted) {
            return ResponseEntity.ok("Successfully deleted configurations for Financial Year: " + financialYearCode + " and Regime: " + regimeCode);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No configurations found to delete for the provided Financial Year and Regime.");
        }
    }

    
    @GetMapping("/getConfigByFinancialYearCode")
    public ResponseEntity<List<FinancialYearRegimeSectionConfig>> getConfigByFinancialYearCode(
            @RequestParam("financialYearCode") String financialYearCode) {
        List<FinancialYearRegimeSectionConfig> configs = service.getConfigByFinancialYearCode(financialYearCode);
        if (configs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(configs);
        }
        return ResponseEntity.ok(configs);
    }
    
    @PutMapping("/update")
    public ResponseEntity<FinancialYearRegimeSectionConfig> updateConfig(
           
            @RequestBody FinancialYearRegimeSectionConfig updatedConfig) {
        try {
            FinancialYearRegimeSectionConfig updated = service.updateConfig(updatedConfig);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
