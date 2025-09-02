package com.pransquare.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pransquare.dashboard.entities.TdsSection;
import com.pransquare.dashboard.services.TdsSectionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/sections")
public class TdsSectionController {

    @Autowired
    private TdsSectionService service;

    // Create a new Section
    @PostMapping
    public ResponseEntity<TdsSection> createSection(@RequestBody TdsSection section) {
        TdsSection newSection = service.createSection(section);
        return ResponseEntity.ok(newSection);
    }

    // Get all Sections
    @GetMapping
    public ResponseEntity<List<TdsSection>> getAllSections() {
        List<TdsSection> sections = service.getAllSections();
        return ResponseEntity.ok(sections);
    }

    // Get a Section by ID
    @GetMapping("/{id}")
    public ResponseEntity<TdsSection> getSectionById(@PathVariable int id) {
        Optional<TdsSection> section = service.getSectionById(id);
        return section.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Section
    @PutMapping("/updateSection")
    public ResponseEntity<TdsSection> updateSection( @RequestBody TdsSection updatedSection) {
        TdsSection section = service.updateSection(updatedSection);
        if (section != null) {
            return ResponseEntity.ok(section);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Section
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable int id) {
        service.deleteSection(id);
        return ResponseEntity.ok().build();
    }
}
