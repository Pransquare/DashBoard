package com.pransquare.dashboard.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.ProjectEntity;
import com.pransquare.dashboard.models.ProjectModel;
import com.pransquare.dashboard.repositories.ProjectRepository;
import com.pransquare.dashboard.utils.IntegerUtils;

@Service
public class ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectEntity> getAllProjects() {
        try {
            logger.info("Retrieving all projects");
            return projectRepository.findAllByStatusNot("deleted");
        } catch (Exception e) {
            logger.error("Error retrieving all projects", e);
            throw new RuntimeException("Error retrieving all projects", e);
        }
    }

    public ProjectEntity dedupeCheckWithProjectCode(String projectCode) {
        try {
            logger.info("Checking for duplicate project code: {}", projectCode);
            return projectRepository.findByProjectCodeAndStatusNot(projectCode, "deleted");
        } catch (Exception e) {
            logger.error("Error checking for duplicate project code", e);
            throw new RuntimeException("Error checking for duplicate project code", e);
        }
    }

    public ProjectEntity createOrUpdateProject(ProjectModel projectModel) {
        try {
            ProjectEntity projectEntity;
            if (!IntegerUtils.isNotNull(projectModel.getProjectId())) {
                logger.info("Updating project with ID: {}", projectModel.getProjectId());
                projectEntity = new ProjectEntity();
                projectEntity.setStatus("active");
                projectEntity.setCreatedBy(projectModel.getUser());
                projectEntity.setCreatedDate(LocalDateTime.now());
            } else {
                Optional<ProjectEntity> existingEntity = projectRepository.findById(projectModel.getProjectId());
                projectEntity = existingEntity.orElseThrow(() -> new IllegalArgumentException(
                        "Project with ID " + projectModel.getProjectId() + " not found"));
                logger.info("Updating project with ID: {}", projectModel.getProjectId());
                projectEntity.setModifiedBy(projectModel.getUser());
                projectEntity.setModifiedDate(LocalDateTime.now());
            }
            projectEntity.setProjectCode(projectModel.getProjectCode());
            projectEntity.setProjectName(projectModel.getProjectName());
            projectEntity.setClientCode(projectModel.getClientCode());
            projectEntity.setLocation(projectModel.getLocation());
            projectEntity.setStartDate(projectModel.getStartDate());
            projectEntity.setEndDate(projectModel.getEndDate());
            return projectRepository.save(projectEntity);
        } catch (Exception e) {
            logger.error("Error creating or updating project", e);
            throw new RuntimeException("Error creating or updating project", e);
        }
    }

    public ProjectEntity deleteProject(Integer projectId) {
        try {
            if (!IntegerUtils.isNotNull(projectId)) {
                throw new IllegalArgumentException("Project ID cannot be null");
            }
            ProjectEntity projectEntity = projectRepository.findById(projectId)
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Project with ID " + projectId + " not found"));
            logger.info("Deleting project with ID: {}", projectId);
            projectEntity.setStatus("deleted");
            return projectRepository.save(projectEntity);
        } catch (Exception e) {
            logger.error("Error deleting project", e);
            throw new RuntimeException("Error deleting project", e);
        }
    }
}