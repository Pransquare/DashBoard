package com.pransquare.dashboard.models;

import java.util.List;

public class FinancialYearRegimeSectionConfigModel {

	private Long id;
	private String financialYearCode;
	private String regimeCode;
	private List<String> sectionCodes;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFinancialYearCode() {
		return financialYearCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getSectionCodes() {
		return sectionCodes;
	}

	public void setSectionCodes(List<String> sectionCodes) {
		this.sectionCodes = sectionCodes;
	}

}
