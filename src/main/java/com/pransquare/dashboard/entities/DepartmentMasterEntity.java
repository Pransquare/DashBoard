package com.pransquare.dashboard.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPARTMENT_MASTER")
public class DepartmentMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_MASTER_ID", nullable = false)
    private int departmentMasterId;

    @Column(name = "DEPARTMENT_CODE", nullable = false, length = 50)
    private String departmentCode;

    @Column(name = "DEPARTMENT_DESCRIPTION", length = 50)
    private String departmentDescription;

    @Column(name = "STATUS", length = 50)
    private String status;

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "MODIFIED_BY", length = 100)
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    // Getters and Setters

    public int getDepartmentMasterId() {
        return departmentMasterId;
    }

    public void setDepartmentMasterId(int departmentMasterId) {
        this.departmentMasterId = departmentMasterId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
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

}