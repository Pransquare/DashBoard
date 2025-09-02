package com.pransquare.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pransquare.dashboard.entities.TdsSubSection;
import com.pransquare.dashboard.services.TdsSubSectionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/subsections")
public class TdsSubSectionController {

    @Autowired
    private TdsSubSectionService service;

    // Create a new SubSection
    @PostMapping
    public ResponseEntity<TdsSubSection> createSubSection(@RequestBody TdsSubSection subSection) {
        TdsSubSection newSubSection = service.createSubSection(subSection);
        return ResponseEntity.ok(newSubSection);
    }

    // Get all SubSections
    @GetMapping
    public ResponseEntity<List<TdsSubSection>> getAllSubSections() {
        List<TdsSubSection> subSections = service.getAllSubSections();
        return ResponseEntity.ok(subSections);
    }

    // Get a SubSection by ID
    @GetMapping("/{id}")
    public ResponseEntity<TdsSubSection> getSubSectionById(@PathVariable int id) {
        Optional<TdsSubSection> subSection = service.getSubSectionById(id);
        return subSection.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a SubSection
    @PutMapping("/updateSubsection")
    public ResponseEntity<TdsSubSection> updateSubSection(@RequestBody TdsSubSection updatedSubSection) {
        TdsSubSection subSection = service.updateSubSection(updatedSubSection);
        if (subSection != null) {
            return ResponseEntity.ok(subSection);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a SubSection
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubSection(@PathVariable int id) {
        service.deleteSubSection(id);
        return ResponseEntity.ok().build();
    }
}
