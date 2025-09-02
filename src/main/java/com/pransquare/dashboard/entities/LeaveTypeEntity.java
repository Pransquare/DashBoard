package com.pransquare.dashboard.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "leave_type_master")
@Entity
public class LeaveTypeEntity {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEAVE_TYPE_MASTER_ID")
	private Integer leaveTypeId;

	@Column(name = "LEAVE_TYPE_CODE")
	private String leaveTypeCode;

	@Column(name = "LEAVE_TYPE_DESCRIPTION")
	private String leaveTypeDescription;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private LocalDate createdDate;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "MODIFIED_DATE")
	private LocalDate modifiedDate;

	@Column(name = "CREDIT_FREQUENCY")
	private String creditFrequency;

	@Column(name = "LEAVE_CREDIT")
	private Float leaveCredit;

	@Column(name = "IS_UNLIMITED")
	private boolean isUnlimited;

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

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public boolean isUnlimited() {
		return isUnlimited;
	}

	public void setUnlimited(boolean isUnlimited) {
		this.isUnlimited = isUnlimited;
	}

	@Override
	public String toString() {
		return "LeaveTypeEntity [leaveTypeId=" + leaveTypeId + ", leaveTypeCode=" + leaveTypeCode
				+ ", leaveTypeDescription=" + leaveTypeDescription + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate
				+ ", creditFrequency=" + creditFrequency + ", leaveCredit=" + leaveCredit + ", isUnlimited="
				+ isUnlimited + "]";
	}

}
