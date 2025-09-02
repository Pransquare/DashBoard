package com.pransquare.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.WorkLocationMasterEntity;
import com.pransquare.dashboard.repositories.WorkLocationMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkLocationMasterService {

    private final WorkLocationMasterRepository workLocationMasterRepository;

    @Autowired
    public WorkLocationMasterService(WorkLocationMasterRepository workLocationMasterRepository) {
        this.workLocationMasterRepository = workLocationMasterRepository;
    }

    // Find all work locations
    public List<WorkLocationMasterEntity> findAll() {
        return workLocationMasterRepository.findAll();
    }

    // Find by ID
    public Optional<WorkLocationMasterEntity> findById(Integer id) {
        return workLocationMasterRepository.findById(id);
    }

    // Find by status
    public List<WorkLocationMasterEntity> findByStatus(String status) {
        return workLocationMasterRepository.findByStatus(status);
    }

    // Create or update work location
    public WorkLocationMasterEntity saveWorkLocation(WorkLocationMasterEntity workLocation) {
        return workLocationMasterRepository.save(workLocation);
    }

    // Delete work location
    public void deleteWorkLocation(Integer id) {
        workLocationMasterRepository.deleteById(id);
    }
}
