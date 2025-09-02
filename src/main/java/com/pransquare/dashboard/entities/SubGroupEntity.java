package com.pransquare.dashboard.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paramsubgroups")
public class SubGroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUB_GROUP_ID")
	private Long subGroupId;

	@Column(name = "SUB_GROUP_NAME")
	private String subGroupName;
	
	@Column(name = "SG_DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "group_id")
	@JsonBackReference
	GroupEntity groupEntity;

	public Long getSubGroupId() {
		return subGroupId;
	}

	public void setSubGroupId(Long subGroupId) {
		this.subGroupId = subGroupId;
	}

	public String getSubGroupName() {
		return subGroupName;
	}

	public void setSubGroupName(String subGroupName) {
		this.subGroupName = subGroupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GroupEntity getGroupEntity() {
		return groupEntity;
	}

	public void setGroupEntity(GroupEntity groupEntity) {
		this.groupEntity = groupEntity;
	}

	
}
