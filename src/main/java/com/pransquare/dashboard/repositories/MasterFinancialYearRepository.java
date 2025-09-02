package com.pransquare.dashboard.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pransquare.dashboard.entities.MasterFinancialYear;

public interface MasterFinancialYearRepository extends JpaRepository<MasterFinancialYear, Long> {
    List<MasterFinancialYear> findByStatus(String status);

	boolean existsByCode(String code);
}
