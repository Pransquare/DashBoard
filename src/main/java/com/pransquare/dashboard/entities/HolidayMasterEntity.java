package com.pransquare.dashboard.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "holiday_master")
public class HolidayMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOLIDAY_MASTER_ID")
	private Long holidayMasterId;

	@Column(name = "HOLIDAY_DATE")
	private LocalDate holidayDate;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "STATE")
	private String state;

	@Column(name = "HOLIDAY_DESCRIPTION")
	private String holidayDescription;

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

	@Column(name = "WORKLOCATION_CODE")
	private String workLocationCode;

	// Getters and Setters
	public Long getHolidayMasterId() {
		return holidayMasterId;
	}

	public void setHolidayMasterId(Long holidayMasterId) {
		this.holidayMasterId = holidayMasterId;
	}

	public LocalDate getHolidayDate() {
		return holidayDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHolidayDescription() {
		return holidayDescription;
	}

	public void setHolidayDescription(String holidayDescription) {
		this.holidayDescription = holidayDescription;
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

	public void setHolidayDate(LocalDate holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getWorkLocationCode() {
		return workLocationCode;
	}

	public void setWorkLocationCode(String workLocationCode) {
		this.workLocationCode = workLocationCode;
	}

}
