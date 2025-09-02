package com.pransquare.dashboard.models;

import java.time.LocalDate;

public class LeaveTypeModel {

    private Integer leaveTypeId;
    private String leaveTypeCode;
    private String leaveTypeDescription;
    private String status;
    private String createdBy;
    private LocalDate createdDate;
    private String modifiedBy;
    private LocalDate modifiedDate;
    private Boolean isUnlimited;
    private String creditFrequency;
    private Float leaveCredit;

    // Getters and setters

    public Integer getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Integer leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveTypeCode() {
        return leaveTypeCode;
    }

    public void setLeaveTypeCode(String leaveTypeCode) {
        this.leaveTypeCode = leaveTypeCode;
    }

    public String getLeaveTypeDescription() {
        return leaveTypeDescription;
    }

    public void setLeaveTypeDescription(String leaveTypeDescription) {
        this.leaveTypeDescription = leaveTypeDescription;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getIsUnlimited() {
        return isUnlimited;
    }

    public void setIsUnlimited(Boolean isUnlimited) {
        this.isUnlimited = isUnlimited;
    }

    public String getCreditFrequency() {
        return creditFrequency;
    }

    public void setCreditFrequency(String creditFrequency) {
        this.creditFrequency = creditFrequency;
    }

    public Float getLeaveCredit() {
        return leaveCredit;
    }

    public void setLeaveCredit(Float leaveCredit) {
        this.leaveCredit = leaveCredit;
    }

}