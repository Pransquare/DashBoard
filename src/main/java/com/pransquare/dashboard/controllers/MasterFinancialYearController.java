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

import com.pransquare.dashboard.entities.MasterFinancialYear;
import com.pransquare.dashboard.services.MasterFinancialYearService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/")
public class MasterFinancialYearController {

    @Autowired
    private MasterFinancialYearService service;

    @GetMapping("/getFinancialYear")
    public ResponseEntity<List<MasterFinancialYear>> getAllActive() {
        List<MasterFinancialYear> financialYears = service.getAllActive();
        return ResponseEntity.ok(financialYears);
    }

    @PostMapping("saveFinancialYear")
    public ResponseEntity<MasterFinancialYear> createOrUpdate(@RequestBody MasterFinancialYear financialYear) {
        MasterFinancialYear updatedFinancialYear = service.createOrUpdate(financialYear);
        return ResponseEntity.ok(updatedFinancialYear);
    }

    @DeleteMapping("/deleteFinancialYear/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateFinancialYear")
    public ResponseEntity<MasterFinancialYear> updateFinancialYear(@RequestBody MasterFinancialYear financialYear) {
        MasterFinancialYear updatedFinancialYear = service.update(financialYear);
        return ResponseEntity.ok(updatedFinancialYear);
    }
}
