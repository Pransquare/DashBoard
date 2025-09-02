package com.pransquare.dashboard.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.BasicGoalsConfig;

@Repository
public interface BasicGoalsConfigRepo extends JpaRepository<BasicGoalsConfig, Integer> {

	Optional<BasicGoalsConfig> findById(Integer id);

	List<BasicGoalsConfig> findByGoalTypeAndStatus(String string, String string2);

	Page<BasicGoalsConfig> findByStatusNot(String string, Pageable pageable);

}
