package com.pransquare.dashboard.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.TdsSection;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.repositories.FinancialYearRegimeSectionConfigRepository;
import com.pransquare.dashboard.repositories.SectionSubsectionConfigurationRepository;
import com.pransquare.dashboard.repositories.TdsSectionRepository;

import jakarta.transaction.Transactional;

@Service
public class TdsSectionService {

    @Autowired
    private TdsSectionRepository repository;
    @Autowired
    private SectionSubsectionConfigurationRepository secSubsecRepository;
    @Autowired
    private FinancialYearRegimeSectionConfigRepository fyRegSecRepo;

    // Create a new Section
    public TdsSection createSection(TdsSection section) {
    	if(repository.existsByCode(section.getCode())) {
    		throw new ResourceNotFoundException("Entered code already exists");
    	}
        return repository.save(section);
    }

    // Get all Sections
    public List<TdsSection> getAllSections() {
        return repository.findAll();
    }

    // Get a Section by ID
    public Optional<TdsSection> getSectionById(int id) {
        return repository.findById(id);
    }

    // Update a Section
    public TdsSection updateSection( TdsSection updatedSection) {
        Optional<TdsSection> existingSection = repository.findById(updatedSection.getId());
        if (existingSection.isPresent()) {
            TdsSection section = existingSection.get();
            section.setCode(updatedSection.getCode());
            section.setDescription(updatedSection.getDescription());
            section.setStatus(updatedSection.getStatus());
            return repository.save(section);
        }
        return null; // Handle this appropriately
    }

    // Delete a Section by ID
    @Transactional
    public void deleteSection(int id) {
    	Optional<TdsSection> sec = repository.findById(id);
    	if(sec.isPresent()) {
    	secSubsecRepository.deleteBySectionCode(sec.get().getCode());
    	fyRegSecRepo.deleteBySectionCode(sec.get().getCode());
        repository.deleteById(id);
    	}
    }
}
