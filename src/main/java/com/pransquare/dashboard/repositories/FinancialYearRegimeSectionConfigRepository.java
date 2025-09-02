package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pransquare.dashboard.entities.FinancialYearRegimeSectionConfig;

public interface FinancialYearRegimeSectionConfigRepository
        extends JpaRepository<FinancialYearRegimeSectionConfig, Long> {
    List<FinancialYearRegimeSectionConfig> findByStatus(String status);

    List<FinancialYearRegimeSectionConfig> findByFinancialYearCode(String financialYearCode);

    // @Query("SELECT COUNT(f) > 0 FROM FinancialYearRegimeSectionConfig f WHERE
    // f.financialYearCode = :financialYearCode AND f.regimeCode = :regimeCode AND
    // f.sectionCode = :sectionCode")
    // boolean existsByCombination(
    // @Param("financialYearCode") String financialYearCode,
    // @Param("regimeCode") String regimeCode,
    // @Param("sectionCode") String sectionCode
    // );

    void deleteBySectionCode(String code);

    void deleteByFinancialYearCode(String code);

    void deleteByRegimeCode(String code);

    @Query("SELECT COUNT(f) > 0 FROM FinancialYearRegimeSectionConfig f WHERE f.financialYearCode = :financialYearCode AND f.regimeCode = :regimeCode AND f.sectionCode = :sectionCode")
    boolean existsByCombination(
            @Param("financialYearCode") String financialYearCode,
            @Param("regimeCode") String regimeCode,
            @Param("sectionCode") String sectionCode);

    // Method to delete sections by financial year and regime codes
    @Modifying
    @Query("DELETE FROM FinancialYearRegimeSectionConfig f WHERE f.financialYearCode = :financialYearCode AND f.regimeCode = :regimeCode AND f.sectionCode IN :sectionCodes")
    void deleteByFinancialYearCodeAndRegimeCodeAndSectionCodes(String financialYearCode, String regimeCode,
            List<String> sectionCodes);

    // Method to find current sections for a specific financial year and regime
    @Query("SELECT sectionCode FROM FinancialYearRegimeSectionConfig f WHERE f.financialYearCode = :financialYearCode AND f.regimeCode = :regimeCode")
    List<String> findSectionCodesByFinancialYearCodeAndRegimeCode(String financialYearCode, String regimeCode);

    @Modifying
    @Query("DELETE FROM FinancialYearRegimeSectionConfig f WHERE f.financialYearCode = :financialYearCode AND f.regimeCode = :regimeCode")
    int deleteByFinancialYearCodeAndRegimeCode(@Param("financialYearCode") String financialYearCode,
            @Param("regimeCode") String regimeCode);
}
