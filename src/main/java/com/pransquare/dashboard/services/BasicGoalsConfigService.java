package com.pransquare.dashboard.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.BasicGoalsConfig;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.GoalSearchModel;
import com.pransquare.dashboard.models.GoalsSetupModel;
import com.pransquare.dashboard.repositories.BasicGoalsConfigRepo;

@Service
public class BasicGoalsConfigService {

	private final BasicGoalsConfigRepo basicGoalsConfigRepo;

	BasicGoalsConfigService(BasicGoalsConfigRepo basicGoalsConfigRepo) {
		this.basicGoalsConfigRepo = basicGoalsConfigRepo;
	}

	public ResponseEntity<List<BasicGoalsConfig>> getBasicGoals() {
		try {
			return ResponseEntity.ok(basicGoalsConfigRepo.findByGoalTypeAndStatus("Basic", "Active"));
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.fillInStackTrace());
		}
	}

	public ResponseEntity<String> saveGoals(GoalsSetupModel goalsSetupModel) {
		try {
			BasicGoalsConfig basicGoalsConfig;

			// Check if ID is provided to update or create a new record
			if ((goalsSetupModel.getId() != null)&&(goalsSetupModel.getId()!=0)) {
				basicGoalsConfig = basicGoalsConfigRepo.findById(goalsSetupModel.getId())
						.orElse(new BasicGoalsConfig());
			} else {
				basicGoalsConfig = new BasicGoalsConfig();
			}

			// Set properties
			basicGoalsConfig.setGoal(goalsSetupModel.getGoal());
			basicGoalsConfig.setGoalDescription(goalsSetupModel.getGoalDescription());
			basicGoalsConfig.setGoalType(goalsSetupModel.getGoalType());
			basicGoalsConfig.setStatus(goalsSetupModel.getStatus());

			// Save to database
			basicGoalsConfigRepo.save(basicGoalsConfig);

			return ResponseEntity.ok(
				    (goalsSetupModel.getId() != null && goalsSetupModel.getId() != 0) 
				        ? "Updated successfully" 
				        : "Saved successfully"
				);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data integrity violation: " + e.getMessage());
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Goal ID not found: " + e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An unexpected error occurred: " + e.getMessage());
		}
	}

	public Map<String, Object> getGoals(GoalSearchModel goalSearchModel) {
	    try {
	        Sort sort = goalSearchModel.getOrder().equalsIgnoreCase("desc")
	                ? Sort.by(goalSearchModel.getSortBy()).descending()
	                : Sort.by(goalSearchModel.getSortBy()).ascending();

	        Pageable pageable = PageRequest.of(goalSearchModel.getPage(), goalSearchModel.getSize(), sort);

	        // Filter out deleted
	        Page<BasicGoalsConfig> goalsPage = basicGoalsConfigRepo.findByStatusNot("deleted", pageable);

	        Map<String, Object> response = new HashMap<>();
	        response.put("goals", goalsPage.getContent());
	        response.put("currentPage", goalsPage.getNumber());
	        response.put("totalPages", goalsPage.getTotalPages());
	        response.put("totalRecords", goalsPage.getTotalElements());
	        response.put("isLastPage", goalsPage.isLast());

	        return response;
	    } catch (Exception e) {
	        return Map.of("error", "Error fetching goals: " + e.getMessage());
	    }
	}

}
