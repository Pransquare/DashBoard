package com.pransquare.dashboard.services;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.HolidayMasterEntity;
import com.pransquare.dashboard.entities.LeaveTypeEntity;
import com.pransquare.dashboard.models.HolidayModel;
import com.pransquare.dashboard.repositories.HolidayMasterRepository;
import com.pransquare.dashboard.utils.IntegerUtils;

@Service
public class HolidayService {

	@Autowired
	HolidayMasterRepository holidayMasterRepository;

	public HolidayMasterEntity createOrUpdateHoliday(HolidayModel holidayModel) {
		HolidayMasterEntity holidayMasterEntity = null;
		if (IntegerUtils.isNotNull(holidayModel.getHolidayMasterId())) {
			Optional<HolidayMasterEntity> holidayMasterEntityOpt = holidayMasterRepository
					.findById(holidayModel.getHolidayMasterId());
			holidayMasterEntity = holidayMasterEntityOpt.get();
			holidayMasterEntity.setCountry(holidayModel.getCountry());
			holidayMasterEntity.setHolidayDate(holidayModel.getHolidayDate());
			holidayMasterEntity.setState(holidayModel.getState());
			holidayMasterEntity.setHolidayDescription(holidayModel.getHolidayDescription());
			holidayMasterEntity.setModifiedBy(holidayModel.getCreatedBy());
			holidayMasterEntity.setModifiedDate(LocalDateTime.now());
			holidayMasterEntity.setStatus(holidayModel.getStatus());
			holidayMasterRepository.save(holidayMasterEntity);

			return holidayMasterEntity;
		} else {
			holidayMasterEntity = new HolidayMasterEntity();
			holidayMasterEntity.setCountry(holidayModel.getCountry());
			holidayMasterEntity.setHolidayDate(holidayModel.getHolidayDate());
			holidayMasterEntity.setState(holidayModel.getState());
			holidayMasterEntity.setHolidayDescription(holidayModel.getHolidayDescription());
			holidayMasterEntity.setCreatedBy(holidayModel.getCreatedBy());
			holidayMasterEntity.setCreatedDate(LocalDateTime.now());
			holidayMasterEntity.setStatus(holidayModel.getStatus());
			holidayMasterRepository.save(holidayMasterEntity);
			return holidayMasterEntity;
		}
	}

	public List<HolidayMasterEntity> getAllHolidays(String workLocation) {
		if (workLocation == null || workLocation.isEmpty()) {
			return holidayMasterRepository.findByYearAndActiveStatus(Year.now().getValue());
		}
		return holidayMasterRepository.findByWorkLocationAndYearAndActiveStatus(workLocation,
				Year.now().getValue());
	}

}
