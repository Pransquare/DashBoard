package com.pransquare.dashboard.models;

import java.util.List;

public class GroupModel {

	private long groupId;
	private String groupName;
	private String description;
	List<SubGroupModel> subGroup;
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<SubGroupModel> getSubGroup() {
		return subGroup;
	}
	public void setSubGroup(List<SubGroupModel> subGroup) {
		this.subGroup = subGroup;
	}
	
	
	
	
}
