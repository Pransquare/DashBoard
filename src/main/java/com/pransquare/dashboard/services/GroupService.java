package com.pransquare.dashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pransquare.dashboard.entities.GoalEntity;
import com.pransquare.dashboard.entities.GroupEntity;
import com.pransquare.dashboard.entities.SubGroupEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.repositories.GoalRepository;
import com.pransquare.dashboard.repositories.GroupRepository;
import com.pransquare.dashboard.repositories.SubGroupRepository;

@Service
public class GroupService {
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	SubGroupRepository subGroupRepository;
	@Autowired
	GoalRepository goalRepository;

	public GroupEntity addGroup(GroupEntity groupEntity) {

		return groupRepository.save(groupEntity);

	}

	public List<GroupEntity> getAllGroups() {
		return (List<GroupEntity>) groupRepository.findAll();
	}

	public GroupEntity addSubGroupsToGroup(Long groupId, List<SubGroupEntity> subGroups) {
		GroupEntity group = groupRepository.findById(groupId)
				.orElseThrow(() -> new RuntimeException("Group not found"));
		for (SubGroupEntity subGroup : subGroups) {
			subGroup.setGroupEntity(group);
			group.getSubGroupDetails().add(subGroup);
		}
		return groupRepository.save(group);
	}

	@Transactional
	public void deleteGroup(Long groupId) {
		GroupEntity group = groupRepository.findById(groupId)
				.orElseThrow(() -> new RuntimeException("Group not found with ID: " + groupId));
		// Cascade delete for subgroups associated with the group
		subGroupRepository.deleteByGroupEntityId(group.getGroupId());
		groupRepository.delete(group);
	}

	public SubGroupEntity addSubGroup(SubGroupEntity subGroup) {
		return subGroupRepository.save(subGroup);
	}

	public List<SubGroupEntity> getAllSubGroup() {

		return subGroupRepository.findallsubgroup();
	}

	@Transactional
	public void deleteSubGroup(Long subGroupId) {
		SubGroupEntity subGroup = subGroupRepository.findById(subGroupId).orElse(null);
		if (subGroup != null) {
			GroupEntity parentGroup = subGroup.getGroupEntity();
			subGroupRepository.delete(subGroup);

			// Check if the parent group has any remaining subgroups
			// List<SubGroupEntity> remainingSubGroups =
			// subGroupRepository.findByGroupDetails_Id(parentGroup.getGroupId());
			// if (remainingSubGroups.isEmpty()) {
			// groupRepository.delete(parentGroup);
			// }
		}

	}

	public List<SubGroupEntity> getSubGroupsByGroupId(Long groupId) {
		return subGroupRepository.findSubGroupsByGroupId(groupId);
	}

	public List<GoalEntity> getAllGoals() {
		try {
			return goalRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResourceNotFoundException(e.fillInStackTrace());
		}
	}
}
