package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.LeaveTypeEntity;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveTypeEntity, Integer> {

    LeaveTypeEntity findByLeaveTypeCodeAndStatusNot(String leaveTypeCode, String status);

    List<LeaveTypeEntity> findByLeaveTypeDescriptionAndStatusNot(String leave, String status);

    LeaveTypeEntity findByLeaveTypeId(Integer leaveTypeId);

}