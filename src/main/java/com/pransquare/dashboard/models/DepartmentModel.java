package com.pransquare.dashboard.models;

public class DepartmentModel {

    private Integer departmentMasterId;
    private String departmentCode;
    private String departmentDescription;
    private String status;
    private String user;

    // Getters and Setters

    public Integer getDepartmentMasterId() {
        return departmentMasterId;
    }

    public void setDepartmentMasterId(Integer departmentMasterId) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}