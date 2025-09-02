package com.pransquare.dashboard.models;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public class TDSInputModel {
	
	private List<String> sectionCodes;
    // private String financialYearCode;
	public List<String> getSectionCodes() {
		return sectionCodes;
	}
	public void setSectionCodes(List<String> sectionCodes) {
		this.sectionCodes = sectionCodes;
	}
	// public String getFinancialYearCode() {
	// 	return financialYearCode;
	// }
	// public void setFinancialYearCode(String financialYearCode) {
	// 	this.financialYearCode = financialYearCode;
	// }
    
    
}
