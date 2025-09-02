package com.pransquare.dashboard.models;

public class SubGroupModel {
	private long subGroupId;
	private String subGroupName;
	private String descrption;
	GroupModel groupModel;
	public long getSubGroupId() {
		return subGroupId;
	}
	public void setSubGroupId(long subGroupId) {
		this.subGroupId = subGroupId;
	}
	public String getSubGroupName() {
		return subGroupName;
	}
	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public GroupModel getGroupModel() {
		return groupModel;
	}
	public void setGroupModel(GroupModel groupModel) {
		this.groupModel = groupModel;
	}
	
	

}
