package com.pransquare.dashboard.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "paramgroups")
public class GroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
	private Long groupId;
	
	@Column(name = "GROUP_NAME")
	private String groupName;
	
	@Column(name = "G_DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy = "groupEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    List<SubGroupEntity> subGroupDetails;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
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

	public List<SubGroupEntity> getSubGroupDetails() {
		return subGroupDetails;
	}

	public void setSubGroupDetails(List<SubGroupEntity> subGroupDetails) {
		this.subGroupDetails = subGroupDetails;
	}
	
	
	
}
