package com.pransquare.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pransquare.dashboard.entities.TdsRegimeMaster;
import com.pransquare.dashboard.services.TdsRegimeMasterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/Regimes")
public class TdsRegimeMasterController {

    @Autowired
    private TdsRegimeMasterService service;

    // Create a new Regime
    @PostMapping
    public ResponseEntity<TdsRegimeMaster> createRegime(@RequestBody TdsRegimeMaster Regime) {
        TdsRegimeMaster newRegime = service.createRegime(Regime);
        return ResponseEntity.ok(newRegime);
    }

    // Get all Regimes
    @GetMapping
    public ResponseEntity<List<TdsRegimeMaster>> getAllRegimes() {
        List<TdsRegimeMaster> Regimes = service.getAllRegimes();
        return ResponseEntity.ok(Regimes);
    }

    // Get a Regime by ID
    @GetMapping("/{id}")
    public ResponseEntity<TdsRegimeMaster> getRegimeById(@PathVariable int id) {
        Optional<TdsRegimeMaster> Regime = service.getRegimeById(id);
        return Regime.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Regime
    @PutMapping("/updateRegime")
    public ResponseEntity<TdsRegimeMaster> updateRegime(@RequestBody TdsRegimeMaster updatedRegime) {
        TdsRegimeMaster Regime = service.updateRegime(updatedRegime);
        if (Regime != null) {
            return ResponseEntity.ok(Regime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Regime
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegime(@PathVariable int id) {
        service.deleteRegime(id);
        return ResponseEntity.ok().build();
    }
}
