package com.pransquare.dashboard.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_master")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_MASTER_ID")
    private Integer projectMasterId;

    @Column(name = "PROJECT_CODE")
    private String projectCode;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "CLIENT_CODE")
    private String clientCode;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany()
    @JoinColumn(name = "CLIENT_CODE", referencedColumnName = "CLIENT_CODE", insertable = false, updatable = false)
    private List<ClientEntity> clientEntity;

    public String getClientName() {
        return clientEntity != null && !clientEntity.isEmpty()
                ? clientEntity.stream().filter(data -> data.getStatus().equals("active"))
                        .findFirst().map(ClientEntity::getClientName).orElse(null)
                : null;
    }

    public Integer getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(Integer projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    // Getters and setters for all fields

}