package com.pransquare.dashboard.models;

import java.util.List;

public class SectionSubsectionInputModel {
	private Long id;
	private String sectionCode;
	private List<String> subSectionCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public List<String> getSubSectionCode() {
		return subSectionCode;
	}

	public void setSubSectionCode(List<String> subSectionCode) {
		this.subSectionCode = subSectionCode;
	}

}
