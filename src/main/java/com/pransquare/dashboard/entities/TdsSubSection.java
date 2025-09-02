package com.pransquare.dashboard.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tds_sub_sections")
public class TdsSubSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private String description;
    private String sectionCode; // Assuming this relates to another entity
    private String status;
//    
//    @OneToMany(mappedBy = "subsection", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SectionSubsectionConfiguration> subsectionConfigurations;

    // Constructors
    public TdsSubSection() {
    }

    public TdsSubSection(String code, String description, String sectionCode, String status) {
        this.code = code;
        this.description = description;
        this.sectionCode = sectionCode;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//	public List<SectionSubsectionConfiguration> getSubsectionConfigurations() {
//		return subsectionConfigurations;
//	}
//
//	public void setSubsectionConfigurations(List<SectionSubsectionConfiguration> subsectionConfigurations) {
//		this.subsectionConfigurations = subsectionConfigurations;
//	}
    
    
}
