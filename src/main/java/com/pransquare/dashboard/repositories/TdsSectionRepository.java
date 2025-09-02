package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.TdsSection;

@Repository
public interface TdsSectionRepository extends JpaRepository<TdsSection, Integer> {

	boolean existsByCode(String code);
}
