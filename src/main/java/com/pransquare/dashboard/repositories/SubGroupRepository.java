package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pransquare.dashboard.entities.SubGroupEntity;

import jakarta.transaction.Transactional;

public interface SubGroupRepository extends JpaRepository<SubGroupEntity, Long> {
	
	@Query("SELECT s FROM SubGroupEntity s WHERE s.groupEntity.groupId = :groupId")
    List<SubGroupEntity> findByGroupEntityId(@Param("groupId") Long groupId);
	
	@Modifying
    @Transactional
    @Query("DELETE FROM SubGroupEntity s WHERE s.groupEntity.groupId = :groupId")
    void deleteByGroupEntityId(Long groupId);
	
	@Query("FROM SubGroupEntity")
	public List<SubGroupEntity> findallsubgroup();

	
	@Transactional
	@Modifying
	@Query("DELETE FROM SubGroupEntity e WHERE e.subGroupName = :subGroupName")
	public void deletebysubgroupname(@Param("subGroupName") String subGroupName);
	
	@Query("SELECT s FROM SubGroupEntity s WHERE s.groupEntity.groupId = :groupId")
    List<SubGroupEntity> findSubGroupsByGroupId(@Param("groupId") Long groupId);

}
