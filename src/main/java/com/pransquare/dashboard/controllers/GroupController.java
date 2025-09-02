package com.pransquare.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.GoalEntity;
import com.pransquare.dashboard.entities.GroupEntity;
import com.pransquare.dashboard.entities.SubGroupEntity;
import com.pransquare.dashboard.exceptions.GroupNotFoundException;
import com.pransquare.dashboard.response.GroupResponse;
import com.pransquare.dashboard.services.GroupService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/groups")
public class GroupController {
	@Autowired
	GroupService groupService;

	@PostMapping("/addgroup")
	public ResponseEntity<GroupResponse> addgroup_subGroup(@RequestBody GroupEntity group) {
		GroupResponse res = new GroupResponse();
		GroupEntity obj = groupService.addGroup(group);
		res.setRes(obj);
		res.setMessage("Success");
		return new ResponseEntity<GroupResponse>(res, HttpStatus.OK);

	}

	@GetMapping("/getGroup")
	public ResponseEntity<GroupResponse> getAllGroups() {
		GroupResponse res = new GroupResponse();
		List<GroupEntity> obj = groupService.getAllGroups();
		res.setRes(obj);
		res.setMessage("Success");
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@PostMapping("/addSubGroup/{groupId}")
	public ResponseEntity<GroupResponse> addSubGroup(@PathVariable Long groupId,
			@RequestBody List<SubGroupEntity> subGroups) {
		GroupResponse res = new GroupResponse();
		GroupEntity updatedGroup = groupService.addSubGroupsToGroup(groupId, subGroups);
		res.setRes(updatedGroup);
		res.setMessage("Success");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@DeleteMapping("/deletegroup/{groupId}")
	public ResponseEntity<GroupResponse> deleteGroup(@PathVariable("groupId") Long groupId) {
		GroupResponse res = new GroupResponse();
		try {
			groupService.deleteGroup(groupId);
			List<GroupEntity> obj = groupService.getAllGroups();
			res.setRes(obj);
			res.setMessage("Successfully deleted group");
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (GroupNotFoundException e) {
			res.setMessage(e.getMessage());
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			res.setMessage("An error occurred while deleting the group");
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addsubgroup")
	public ResponseEntity<GroupResponse> addsubgroup(@RequestBody SubGroupEntity subGroupDetails) {
		GroupResponse res = new GroupResponse();
		SubGroupEntity obj = groupService.addSubGroup(subGroupDetails);
		res.setRes(obj);
		res.setMessage("Success");
		return new ResponseEntity<GroupResponse>(res, HttpStatus.OK);

	}

	@GetMapping("/getsubgroup")
	public ResponseEntity<GroupResponse> getallsubgroup() {
		GroupResponse res = new GroupResponse();
		List<SubGroupEntity> obj = groupService.getAllSubGroup();
		res.setRes(obj);
		res.setMessage("Success");
		return new ResponseEntity<GroupResponse>(res, HttpStatus.OK);
	}

	@DeleteMapping("/deleteSubGroup/{groupId}/{subGroupId}")
	public ResponseEntity<GroupResponse> deleteSubGroup(
			@PathVariable("groupId") Long groupId,
			@PathVariable("subGroupId") Long subGroupId) {
		GroupResponse res = new GroupResponse();
		groupService.deleteSubGroup(subGroupId);
		List<GroupEntity> obj = groupService.getAllGroups();
		res.setRes(obj);
		res.setMessage("Successfully deleted subgroup");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/getsubgroup/{groupId}")
	public ResponseEntity<GroupResponse> getAllSubGroups(@PathVariable("groupId") Long groupId) {
		GroupResponse res = new GroupResponse();
		List<SubGroupEntity> obj = groupService.getSubGroupsByGroupId(groupId);
		res.setRes(obj);
		res.setMessage("Success");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/getAllGoals")
	public List<GoalEntity> getAllGoals() {
		return groupService.getAllGoals();
	}

}
