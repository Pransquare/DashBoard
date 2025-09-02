package com.pransquare.dashboard.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERFORMANCE_PARAMETERS")
public class PerformanceParametersEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERFORMANCE_PARAMETER_ID")
	private Long performanceParameterId;
	
	@Column(name = "PERFORMANCE_PARAMETER_NAME")
	private String performanceParameterName;
	
	@Column(name = "PERFORMANCE_PARAMETER_DESCRIPTION")
	private String performanceParameterDesc;
	
	@Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

	public Long getPerformanceParameterId() {
		return performanceParameterId;
	}

	public void setPerformanceParameterId(Long performanceParameterId) {
		this.performanceParameterId = performanceParameterId;
	}

	public String getPerformanceParameterName() {
		return performanceParameterName;
	}

	public void setPerformanceParameterName(String performanceParameterName) {
		this.performanceParameterName = performanceParameterName;
	}

	public String getPerformanceParameterDesc() {
		return performanceParameterDesc;
	}

	public void setPerformanceParameterDesc(String performanceParameterDesc) {
		this.performanceParameterDesc = performanceParameterDesc;
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
