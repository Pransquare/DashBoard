package com.pransquare.dashboard.models;

public class DesignationModel {

	private Integer designationMasterId;
	private String designationCode;
	private String designationDescription;
	private String Status;
	private String user;

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
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getDesignationMasterId() {
		return designationMasterId;
	}

	public void setDesignationMasterId(Integer designationMasterId) {
		this.designationMasterId = designationMasterId;
	}

}
