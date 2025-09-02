package com.pransquare.dashboard.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.DesignationEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.DesignationModel;
import com.pransquare.dashboard.repositories.DesignationRepository;
import com.pransquare.dashboard.utils.IntegerUtils;

@Service
public class DesignationService {

	private static final Logger logger = LoggerFactory.getLogger(DesignationService.class);

	@Autowired
	private DesignationRepository designationRepository;

	public DesignationEntity dedupeCheckWithDesignationCode(String designationCode) {
		if (designationCode == null || designationCode.isEmpty()) {
			throw new IllegalArgumentException("Designation code cannot be null or empty");
		}
		return designationRepository.findByDesignationCodeAndStatusNot(designationCode, "deleted");
	}

	public List<DesignationEntity> getAllDesignations() {
		return designationRepository.findAllByStatusNot("deleted"); // ;
	}

	public DesignationEntity createOrUpdateDesignation(DesignationModel designationModel) {
		if (designationModel == null) {
			throw new IllegalArgumentException("Designation model cannot be null");
		}

		DesignationEntity designation;
		if (!IntegerUtils.isNotNull(designationModel.getDesignationMasterId())) {
			designation = new DesignationEntity();
			List<DesignationEntity> designationEntities = designationRepository
					.findByDesignationDescriptionAndStatusNot(designationModel.getDesignationDescription(), "deleted");
			if (!designationEntities.isEmpty()) {
				throw new IllegalArgumentException("Designation already exists");
			}
			designation.setCreatedBy(designationModel.getUser());
			designation.setCreatedDate(LocalDateTime.now());
			designation.setStatus("active");
		} else {
			Optional<DesignationEntity> existingDesignation = designationRepository
					.findById(designationModel.getDesignationMasterId());
			if (!existingDesignation.isPresent()) {
				throw new IllegalArgumentException(
						"Designation with ID " + designationModel.getDesignationMasterId() + " not found");
			}
			designation = existingDesignation.get();
			designation.setModifiedBy(designationModel.getUser());
			designation.setModifiedDate(LocalDateTime.now());
		}

		designation.setDesignationCode(designationModel.getDesignationCode());
		designation.setDesignationDescription(designationModel.getDesignationDescription());

		try {
			return designationRepository.save(designation);
		} catch (Exception e) {
			logger.error("Error saving designation: ", e.fillInStackTrace());
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	public DesignationEntity deleteDesignation(Integer designationMasterId) {
		if (!IntegerUtils.isNotNull(designationMasterId)) {
			throw new IllegalArgumentException("Designation ID cannot be null");
		}

		DesignationEntity designationEntity = designationRepository.findByDesignationMasterId(designationMasterId);
		if (designationEntity != null) {
			designationEntity.setStatus("deleted");
			designationRepository.save(designationEntity);
		}
		return designationEntity;
	}

	public String getDesignation(String designationCode) {
		String designation=null;
			if (designationCode == null || designationCode.isEmpty()) {
				throw new IllegalArgumentException("Designation code cannot be null or empty");
			}
			designation= designationRepository.findByDesignationCode(designationCode).getDesignationDescription();
			 return designation;
		}

}