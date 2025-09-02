package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.DesignationEntity;

@Repository
public interface DesignationRepository extends JpaRepository<DesignationEntity, Integer> {

    DesignationEntity findByDesignationCodeAndStatusNot(String designationCode, String status);

    List<DesignationEntity> findByDesignationDescriptionAndStatusNot(String designationCode, String status);

    List<DesignationEntity> findAllByStatusNot(String status);

    DesignationEntity findByDesignationMasterId(Integer designationMasterId);

	DesignationEntity findByDesignationCode(String designationCode);
}
