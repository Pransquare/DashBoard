package com.pransquare.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.TdsRegimeMaster;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.repositories.FinancialYearRegimeSectionConfigRepository;
import com.pransquare.dashboard.repositories.TdsRegimeMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TdsRegimeMasterService {

    @Autowired
    private TdsRegimeMasterRepository repository;
    
    @Autowired
    private FinancialYearRegimeSectionConfigRepository fyRegSecRepo;

    // Create a new Regime
    public TdsRegimeMaster createRegime(TdsRegimeMaster regime) {
    	if(repository.existsByCode(regime.getCode())) {
    		throw new ResourceNotFoundException("Entered code already exists");
    	}
        return repository.save(regime);
    }

    // Get all Regimes
    public List<TdsRegimeMaster> getAllRegimes() {
        return repository.findAll();
    }

    // Get a Regime by ID
    public Optional<TdsRegimeMaster> getRegimeById(int id) {
        return repository.findById(id);
    }

    // Update a Regime
    public TdsRegimeMaster updateRegime(TdsRegimeMaster updatedRegime) {
        Optional<TdsRegimeMaster> existingRegime = repository.findById(updatedRegime.getId());
        if (existingRegime.isPresent()) {
            TdsRegimeMaster regime = existingRegime.get();
            regime.setCode(updatedRegime.getCode());
            regime.setRegimeDescription(updatedRegime.getRegimeDescription());
            regime.setStatus(updatedRegime.getStatus());
            return repository.save(regime);
        }
        return null; // Handle this appropriately
    }

    // Delete a Regime by ID
    public void deleteRegime(int id) {
    	Optional<TdsRegimeMaster> existingRegime = repository.findById(id);
        if (existingRegime.isPresent()) {
    	fyRegSecRepo.deleteByRegimeCode(existingRegime.get().getCode());
        repository.deleteById(id);
        }
    }
}
