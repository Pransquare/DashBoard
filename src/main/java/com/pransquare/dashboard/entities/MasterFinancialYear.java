package com.pransquare.dashboard.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "master_financial_year")
public class MasterFinancialYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "financial_year", nullable = false)
    private String financialYear;
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "status", nullable = false)
    private String status = "Active"; // Default status
    
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "financial_year_code", referencedColumnName = "code")
//    @JsonManagedReference
//    private List<FinancialYearRegimeSectionConfig> financialYearRegimeConfigs;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    private void setCode(String code) {
        this.code = code;
    }
    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
//    @JsonManagedReference
//	public List<FinancialYearRegimeSectionConfig> getFinancialYearRegimeConfigs() {
//		return financialYearRegimeConfigs;
//	}
//
//	public void setFinancialYearRegimeConfigs(List<FinancialYearRegimeSectionConfig> financialYearRegimeConfigs) {
//		this.financialYearRegimeConfigs = financialYearRegimeConfigs;
//	}
    
    
}
