package com.pransquare.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.TdsSubSection;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.repositories.SectionSubsectionConfigurationRepository;
import com.pransquare.dashboard.repositories.TdsSubSectionRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TdsSubSectionService {

	@Autowired
	private TdsSubSectionRepository repository;
	@Autowired
	private SectionSubsectionConfigurationRepository secSubsecRepository;

	// Create a new SubSection
	public TdsSubSection createSubSection(TdsSubSection subSection) {
		if (repository.existsByCode(subSection.getCode())) {
			throw new ResourceNotFoundException("Entered code already exists");
		}
		return repository.save(subSection);
	}

	// Get all SubSections
	public List<TdsSubSection> getAllSubSections() {
		return repository.findAll();
	}

	// Get a SubSection by ID
	public Optional<TdsSubSection> getSubSectionById(int id) {
		return repository.findById(id);
	}

	// Update a SubSection
	public TdsSubSection updateSubSection(TdsSubSection updatedSubSection) {
		Optional<TdsSubSection> existingSubSection = repository.findById(updatedSubSection.getId());
		if (existingSubSection.isPresent()) {
			TdsSubSection subSection = existingSubSection.get();
			subSection.setCode(updatedSubSection.getCode());
			subSection.setDescription(updatedSubSection.getDescription());
			subSection.setSectionCode(updatedSubSection.getSectionCode());
			subSection.setStatus(updatedSubSection.getStatus());
			return repository.save(subSection);
		}
		return null; // Handle this appropriately
	}

	// Delete a SubSection by ID
	@Transactional
	public void deleteSubSection(int id) {
		Optional<TdsSubSection> subsec = repository.findById(id);
		if (subsec.isPresent()) {
			secSubsecRepository.deleteBySubsectionCode(subsec.get().getCode());
			repository.deleteById(id);
		}
	}
}
