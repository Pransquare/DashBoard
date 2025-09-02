package com.pransquare.dashboard.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pransquare.dashboard.entities.FinancialYearRegimeSectionConfig;
import com.pransquare.dashboard.models.FinancialYearRegimeSectionConfigModel;
import com.pransquare.dashboard.repositories.FinancialYearRegimeSectionConfigRepository;

@Service
public class FinancialYearRegimeSectionConfigService {

    @Autowired
    private FinancialYearRegimeSectionConfigRepository repository;

    public List<FinancialYearRegimeSectionConfig> getAllActive() {
        return repository.findByStatus("Active");
    }

    @Transactional
    public List<FinancialYearRegimeSectionConfig> createOrUpdate(FinancialYearRegimeSectionConfigModel config) {
        List<FinancialYearRegimeSectionConfig> updatedConfigs = new ArrayList<>();

        if (config != null) {
            // First, let's handle the removal of any section combinations that are no
            // longer in the list.
            List<String> sectionCodesToRemove = getSectionsToRemove(config); // Helper method for getting sections to
                                                                             // remove
            if (!sectionCodesToRemove.isEmpty()) {
                try {
                    repository.deleteByFinancialYearCodeAndRegimeCodeAndSectionCodes(config.getFinancialYearCode(),
                            config.getRegimeCode(), sectionCodesToRemove);
                } catch (Exception e) {
                    System.out.println(e.fillInStackTrace());
                }
            }

            // Then, we handle adding new sections
            if (config.getSectionCodes() != null) {
                config.getSectionCodes().forEach(sectionCode -> {
                    if (!repository.existsByCombination(config.getFinancialYearCode(), config.getRegimeCode(),
                            sectionCode)) {
                        FinancialYearRegimeSectionConfig newConfig = new FinancialYearRegimeSectionConfig(
                                "Active",
                                config.getFinancialYearCode(),
                                config.getRegimeCode(),
                                sectionCode);
                        updatedConfigs.add(newConfig);
                    }
                });
            }
        }

        // Save only new configurations
        return repository.saveAll(updatedConfigs);
    }

    // Helper method to get section codes to be removed
    private List<String> getSectionsToRemove(FinancialYearRegimeSectionConfigModel config) {
        List<String> currentSectionCodes = repository.findSectionCodesByFinancialYearCodeAndRegimeCode(
                config.getFinancialYearCode(), config.getRegimeCode());
        List<String> newSectionCodes = config.getSectionCodes();

        // Find out the section codes that need to be removed
        currentSectionCodes.removeAll(newSectionCodes);
        return currentSectionCodes;
    }

    public String delete(Long id) {
        FinancialYearRegimeSectionConfig config = repository.findById(id).orElse(null);
        if (config != null) {
            config.setStatus("Inactive");
            repository.save(config);
            return "Sucessfully Deleted";
        } else {
            return "No Configaration found with given ID";
        }
    }

    public List<FinancialYearRegimeSectionConfig> getConfigByFinancialYearCode(String financialYearCode) {
        return repository.findByFinancialYearCode(financialYearCode);
    }

    public FinancialYearRegimeSectionConfig updateConfig(FinancialYearRegimeSectionConfig updatedConfig) {
        Optional<FinancialYearRegimeSectionConfig> existingConfigOpt = repository.findById(updatedConfig.getId());

        if (existingConfigOpt.isEmpty()) {
            throw new IllegalArgumentException("Entity not found with ID: " + updatedConfig.getId());
        }

        FinancialYearRegimeSectionConfig existingConfig = existingConfigOpt.get();
        existingConfig.setStatus(updatedConfig.getStatus());
        existingConfig.setFinancialYearCode(updatedConfig.getFinancialYearCode());
        existingConfig.setRegimeCode(updatedConfig.getRegimeCode());
        existingConfig.setSectionCode(updatedConfig.getSectionCode());

        // Save updated entity
        return repository.save(existingConfig);
    }

    @Transactional
    public boolean deleteByFinancialYearCodeAndRegimeCode(String financialYearCode, String regimeCode) {
        // Count records before deleting
        int deletedCount = repository.deleteByFinancialYearCodeAndRegimeCode(financialYearCode, regimeCode);
        return deletedCount > 0; // If records were deleted, return true
    }

}
