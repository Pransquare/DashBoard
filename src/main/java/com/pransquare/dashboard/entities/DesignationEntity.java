package com.pransquare.dashboard.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "designation_master")
@Entity(name = "designation_master")
public class DesignationEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DESIGNATION_MASTER_ID")
	private Integer designationMasterId;
	@Column(name = "DESIGNATION_CODE")
	private String designationCode;
	@Column(name = "DESIGNATION_DESCRIPTION")
	private String designationDescription;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	@Column(name = "MODIFIED_DATE")
	private LocalDateTime modifiedDate;

	public String getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	public String getDesignationDescription() {
		return designationDescription;
	}

	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DesignationEntity [designationMasterId=" + designationMasterId + ", designationCode=" + designationCode
				+ ", designationDescription=" + designationDescription + ", status=" + status + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate="
				+ modifiedDate + "]";
	}

	public Integer getDesignationMasterId() {
		return designationMasterId;
	}

	public void setDesignationMasterId(Integer designationMasterId) {
		this.designationMasterId = designationMasterId;
	}

}
