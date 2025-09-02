package com.pransquare.dashboard.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.BasicGoalsConfig;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.GoalSearchModel;
import com.pransquare.dashboard.models.GoalsSetupModel;
import com.pransquare.dashboard.services.BasicGoalsConfigService;

@RestController
@RequestMapping(value = "/Pransquare/MasterConfiguration/basicgoals")
public class BasicGoalsConfigController {

    private BasicGoalsConfigService basicGoalsConfigService;

    BasicGoalsConfigController(BasicGoalsConfigService basicGoalsConfigService) {
        this.basicGoalsConfigService = basicGoalsConfigService;
    }

    @GetMapping("/goals")
    public ResponseEntity<List<BasicGoalsConfig>> getGoals() {
        return basicGoalsConfigService.getBasicGoals();
    }
    
    @PostMapping("/saveGoal")
    public ResponseEntity<String> saveGoals(@RequestBody GoalsSetupModel goalsSetupModel) {
        return basicGoalsConfigService.saveGoals(goalsSetupModel);
    }
    
    @PostMapping("/searchGoals")
    public ResponseEntity<Map<String, Object>> searchGoals(@RequestBody GoalSearchModel goalSearchModel) {
    	Map<String, Object> result=new HashMap<String, Object>();
    	result=basicGoalsConfigService.getGoals(goalSearchModel);
    	if(result==null) {
    		throw new ResourceNotFoundException("No goals found");
    	}
    	else {
    	return ResponseEntity.ok(result );
    	}
    }
}
