package com.pransquare.dashboard.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.ProjectEntity;
import com.pransquare.dashboard.models.ProjectModel;
import com.pransquare.dashboard.services.ProjectService;

@RestController
@RequestMapping(value = "/Pransquare/MasterConfiguration/projects")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getAllProjects")
    public List<ProjectEntity> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/dedupeCheckWithProjectCode/{projectCode}")
    public ProjectEntity dedupeCheckWithProjectCode(@PathVariable String projectCode) {
        return projectService.dedupeCheckWithProjectCode(projectCode);
    }

    @PostMapping("/createOrUpdateProject")
    public ResponseEntity<ProjectEntity> createOrUpdateProject(@RequestBody ProjectModel projectModel) {
        try {
            ProjectEntity projectEntity = projectService.createOrUpdateProject(projectModel);
            if (projectModel.getProjectId() == null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(projectEntity);
            } else {
                return ResponseEntity.ok(projectEntity);
            }
        } catch (Exception e) {
            logger.error("Error creating or updating client: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/deleteProject/{projectId}")
    public ProjectEntity deleteProject(@PathVariable Integer projectId) {
        return projectService.deleteProject(projectId);
    }
}