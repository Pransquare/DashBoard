package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long>{
	

}
