package com.pransquare.dashboard.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.MasterFinancialYear;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.repositories.FinancialYearRegimeSectionConfigRepository;
import com.pransquare.dashboard.repositories.MasterFinancialYearRepository;

@Service
public class MasterFinancialYearService {

    @Autowired
    private MasterFinancialYearRepository repository;
    @Autowired
    private FinancialYearRegimeSectionConfigRepository fyRegSecRepo;

    public List<MasterFinancialYear> getAllActive() {
        return repository.findByStatus("Active");
    }

    public MasterFinancialYear createOrUpdate(MasterFinancialYear financialYear) {
    	if(repository.existsByCode(financialYear.getCode())) {
    		throw new ResourceNotFoundException("Entered code already exists");
    		
    	}
        return repository.save(financialYear);
    }

    public void delete(Long id) {
        MasterFinancialYear financialYear = repository.findById(id).orElse(null);
        if (financialYear != null) {
//            financialYear.setStatus("Inactive");
//            repository.save(financialYear);
        	fyRegSecRepo.deleteByFinancialYearCode(financialYear.getCode());
        	repository.deleteById(id);
        }
    }

    public MasterFinancialYear update(MasterFinancialYear financialYear) {
        MasterFinancialYear financial = repository.findById(financialYear.getId()).orElse(null);
        if(financial==null){
            throw new ResourceNotFoundException("Please enter correct details");
        }
        return repository.save(financialYear);
    }
}
