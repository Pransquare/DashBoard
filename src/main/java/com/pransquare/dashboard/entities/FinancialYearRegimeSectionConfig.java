package com.pransquare.dashboard.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "financial_year_regime_section_config")
public class FinancialYearRegimeSectionConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false)
    private String status = "Active"; // Default status

    // String fields for codes
    @Column(name = "financial_year_code", nullable = false)
    private String financialYearCode;

    @Column(name = "regime_code", nullable = false)
    private String regimeCode;

    @Column(name = "section_code", nullable = false)
    private String sectionCode;

    // Many-to-one mapping to MasterFinancialYear
    @ManyToOne
    @JoinColumn(name = "financial_year_code", referencedColumnName = "code", insertable = false, updatable = false)
    @JsonBackReference
    private MasterFinancialYear financialYear;

    // Many-to-one mapping to TdsRegimeMaster
    @ManyToOne
    @JoinColumn(name = "regime_code", referencedColumnName = "code", insertable = false, updatable = false)
    private TdsRegimeMaster regime;

    // Many-to-one mapping to TdsSection
    @ManyToOne
    @JoinColumn(name = "section_code", referencedColumnName = "code", insertable = false, updatable = false)
    private TdsSection section;
    public FinancialYearRegimeSectionConfig() {

}


    public FinancialYearRegimeSectionConfig(String status, String financialYearCode, String regimeCode,
            String sectionCode) {
        this.status = status;
        this.financialYearCode = financialYearCode;
        this.regimeCode = regimeCode;
        this.sectionCode = sectionCode;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinancialYearCode() {
        return financialYearCode;
    }

    public void setFinancialYearCode(String financialYearCode) {
        this.financialYearCode = financialYearCode;
    }

    public String getRegimeCode() {
        return regimeCode;
    }

    public void setRegimeCode(String regimeCode) {
        this.regimeCode = regimeCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }
    @JsonBackReference
    public MasterFinancialYear getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(MasterFinancialYear financialYear) {
        this.financialYear = financialYear;
    }

    public TdsRegimeMaster getRegime() {
        return regime;
    }

    public void setRegime(TdsRegimeMaster regime) {
        this.regime = regime;
    }

    public TdsSection getSection() {
        return section;
    }

    public void setSection(TdsSection section) {
        this.section = section;
    }
}
