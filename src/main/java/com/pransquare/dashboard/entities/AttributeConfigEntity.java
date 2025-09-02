package com.pransquare.dashboard.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "attribute_config")
@Entity
public class AttributeConfigEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attribute_config_id")
	private Integer attributeConfigId;

	@Column(name = "attribute_name")
	private String attributeName;

	@Column(name = "status")
	private String status;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	public Integer getAttributeConfigId() {
		return attributeConfigId;
	}

	public void setAttributeConfigId(Integer attributeConfigId) {
		this.attributeConfigId = attributeConfigId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "AttributeConfigEntity [attributeConfigId=" + attributeConfigId + ", attributeName=" + attributeName
				+ ", status=" + status + ", modifiedBy=" + modifiedBy + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
