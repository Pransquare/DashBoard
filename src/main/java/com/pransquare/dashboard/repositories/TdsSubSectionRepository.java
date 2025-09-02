package com.pransquare.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.TdsSubSection;

@Repository
public interface TdsSubSectionRepository extends JpaRepository<TdsSubSection, Integer> {

	boolean existsByCode(String code);
}
