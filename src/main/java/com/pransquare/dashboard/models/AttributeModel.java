package com.pransquare.dashboard.models;

public class AttributeModel {

	private Integer attributeConfigId;
	private String attributeName;
	private String status;
	private String createdBy;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "AttributeModel [attributeConfigId=" + attributeConfigId + ", attributeName=" + attributeName
				+ ", status=" + status + ", createdBy=" + createdBy + "]";
	}

}
