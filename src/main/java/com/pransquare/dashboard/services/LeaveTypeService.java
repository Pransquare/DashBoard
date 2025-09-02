package com.pransquare.dashboard.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.pransquare.dashboard.entities.LeaveTypeEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.LeaveTypeModel;
import com.pransquare.dashboard.repositories.LeaveTypeRepository;
import com.pransquare.dashboard.utils.IntegerUtils;

@Service
public class LeaveTypeService {

	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeService.class);

	@Autowired
	private LeaveTypeRepository leaveTypeRepository;

	public LeaveTypeEntity dedupeCheckWithLeaveTypeCode(@RequestParam String leaveTypeCode) {
		if (leaveTypeCode == null || leaveTypeCode.isEmpty()) {
			throw new IllegalArgumentException("Leave type code cannot be null or empty");
		}
		return leaveTypeRepository.findByLeaveTypeCodeAndStatusNot(leaveTypeCode, "deleted");
	}

	public List<LeaveTypeEntity> getAllLeaveTypes() {
		return leaveTypeRepository.findAll().stream()
				.filter(data -> data.getStatus() != null && !data.getStatus().equals("deleted"))
				.collect(Collectors.toList());
	}

	public LeaveTypeEntity createOrUpdateLeaveType(LeaveTypeModel leaveTypeModel) {
		if (leaveTypeModel == null) {
			throw new IllegalArgumentException("Leave type model cannot be null");
		}

		LeaveTypeEntity leaveType;
		if (!IntegerUtils.isNotNull(leaveTypeModel.getLeaveTypeId())) {
			leaveType = new LeaveTypeEntity();
			List<LeaveTypeEntity> leaveTypeEntities = leaveTypeRepository
					.findByLeaveTypeDescriptionAndStatusNot(leaveTypeModel.getLeaveTypeDescription(), "deleted");
			if (!leaveTypeEntities.isEmpty()) {
				throw new IllegalArgumentException("Leave type description already exists");
			}
			leaveType.setCreatedBy(leaveTypeModel.getCreatedBy());
			leaveType.setCreatedDate(LocalDate.now());
			leaveType.setStatus("active");
		} else {
			Optional<LeaveTypeEntity> existingLeaveType = leaveTypeRepository.findById(leaveTypeModel.getLeaveTypeId());
			if (!existingLeaveType.isPresent()) {
				throw new IllegalArgumentException(
						"Leave type with ID " + leaveTypeModel.getLeaveTypeId() + " not found");
			}
			leaveType = existingLeaveType.get();
			leaveType.setModifiedBy(leaveTypeModel.getModifiedBy());
			leaveType.setModifiedDate(LocalDate.now());
		}

		leaveType.setLeaveTypeCode(leaveTypeModel.getLeaveTypeCode());
		leaveType.setUnlimited(leaveTypeModel.getIsUnlimited());
		leaveType.setLeaveTypeDescription(leaveTypeModel.getLeaveTypeDescription());
		leaveType.setCreditFrequency(leaveTypeModel.getCreditFrequency());
		leaveType.setLeaveCredit(leaveTypeModel.getLeaveCredit());

		try {
			return leaveTypeRepository.save(leaveType);
		} catch (Exception e) {
			logger.error("Error saving leave type: ", e);
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	public LeaveTypeEntity deleteLeaveType(Integer leaveTypeId) {
		if (!IntegerUtils.isNotNull(leaveTypeId)) {
			throw new IllegalArgumentException("Leave type ID cannot be null");
		}
		LeaveTypeEntity leaveTypeEntity = leaveTypeRepository.findByLeaveTypeId(leaveTypeId);
		if (leaveTypeEntity != null) {
			leaveTypeEntity.setStatus("deleted");
			leaveTypeRepository.save(leaveTypeEntity);
		}
		return leaveTypeEntity;
	}
}