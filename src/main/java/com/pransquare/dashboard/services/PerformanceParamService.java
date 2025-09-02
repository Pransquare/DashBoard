package com.pransquare.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pransquare.dashboard.entities.GroupEntity;
import com.pransquare.dashboard.entities.PerformanceParametersEntity;
import com.pransquare.dashboard.repositories.PerformanceParamRepository;

@Service
public class PerformanceParamService {
	
	@Autowired
	PerformanceParamRepository performanceParamRepository;
	
	public PerformanceParametersEntity addParam(PerformanceParametersEntity paramEntity) {
		
		return performanceParamRepository.save(paramEntity);
        
    }
	
	public List<PerformanceParametersEntity> getAllParams() {
        return (List<PerformanceParametersEntity>) performanceParamRepository.findAll();
    }
	
	@Transactional
	public void deleteParam(Long paramId) {
		PerformanceParametersEntity param = performanceParamRepository.findById(paramId).orElseThrow(() -> new RuntimeException("Group not found with ID: " + paramId));
		performanceParamRepository.delete(param);
	}

}
