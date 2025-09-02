package com.pransquare.dashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.SectionSubsectionConfiguration;
import com.pransquare.dashboard.models.SectionSubsectionInputModel;
import com.pransquare.dashboard.models.TDSInputModel;
import com.pransquare.dashboard.repositories.SectionSubsectionConfigurationRepository;

@Service
public class SectionSubsectionConfigurationService {

    @Autowired
    private SectionSubsectionConfigurationRepository repository;

    // Get all active SectionSubsectionConfiguration records
    public List<SectionSubsectionConfiguration> getAllActive() {
        return repository.findByStatus("Active");
    }

    // Create or update a SectionSubsectionConfiguration record
    public List<SectionSubsectionConfiguration> createOrUpdate(SectionSubsectionInputModel config) {
        List<SectionSubsectionConfiguration> sections = new ArrayList<>();
        
        if (config != null && config.getSubSectionCode() != null) {
            config.getSubSectionCode().forEach(sub -> {
                // Check if the combination already exists
                if (!repository.existsBySectionCodeAndSubsectionCode(config.getSectionCode(), sub)) {
                    sections.add(new SectionSubsectionConfiguration(
                        config.getSectionCode(),
                        sub,
                        "Active"
                    ));
                }
            });
        }

        // Save only the new configurations
        return repository.saveAll(sections);
    }

    // Delete a SectionSubsectionConfiguration record by id
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Fetch records by list of sectionCodes and financialYearCodes
    public List<SectionSubsectionConfiguration> getBySectionCodes(TDSInputModel tDSInputModel) {
        return repository.findBySectionCodeIn(tDSInputModel.getSectionCodes());
    }

    public SectionSubsectionConfiguration updateConfiguration(SectionSubsectionInputModel inputModel) {
        // Fetch the configuration by ID
        SectionSubsectionConfiguration existingConfig = repository.findById(inputModel.getId())
                .orElseThrow(() -> new RuntimeException("Configuration with ID " + inputModel.getId() + " not found"));

        // Update attributes based on the input model
        if (inputModel.getSectionCode() != null) {
            existingConfig.setSectionCode(inputModel.getSectionCode());
        }

        if (inputModel.getSubSectionCode() != null && !inputModel.getSubSectionCode().isEmpty()) {
            // Update subsection codes (only the first is considered here for simplicity)
            existingConfig.setSubsectionCode(inputModel.getSubSectionCode().get(0));
        }


        // Save the updated configuration
        return repository.save(existingConfig);
    }
}
