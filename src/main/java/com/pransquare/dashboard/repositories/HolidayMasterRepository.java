package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.HolidayMasterEntity;

@Repository
public interface HolidayMasterRepository extends JpaRepository<HolidayMasterEntity, Long>,
		JpaSpecificationExecutor<HolidayMasterEntity>, PagingAndSortingRepository<HolidayMasterEntity, Long> {

	List<HolidayMasterEntity> findByCountryAndState(String country, String state);

	List<HolidayMasterEntity> findByWorkLocationCode(String workLocation);

	@Query("SELECT h FROM HolidayMasterEntity h WHERE h.workLocationCode = :workLocation AND YEAR(h.holidayDate) = :year AND h.status = 'Active' ORDER BY h.holidayDate ASC")
	List<HolidayMasterEntity> findByWorkLocationAndYearAndActiveStatus(@Param("workLocation") String workLocation, @Param("year") int year);


	@Query("SELECT h FROM HolidayMasterEntity h WHERE YEAR(h.holidayDate) = :year AND h.status = 'Active' ORDER BY h.holidayDate ASC")
	List<HolidayMasterEntity> findByYearAndActiveStatus(@Param("year") int year);

}
