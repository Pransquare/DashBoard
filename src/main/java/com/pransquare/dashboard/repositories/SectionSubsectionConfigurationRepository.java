package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pransquare.dashboard.entities.SectionSubsectionConfiguration;

public interface SectionSubsectionConfigurationRepository extends JpaRepository<SectionSubsectionConfiguration, Long> {

    // Find all SectionSubsectionConfiguration by status 'Active'
    List<SectionSubsectionConfiguration> findByStatus(String status);

    List<SectionSubsectionConfiguration> findBySectionCodeIn(List<String> sectionCodes);
    
    boolean existsBySectionCodeAndSubsectionCode(String sectionCode, String subsectionCode);

	void deleteBySectionCode(String code);

	void deleteBySubsectionCode(String code);
}
