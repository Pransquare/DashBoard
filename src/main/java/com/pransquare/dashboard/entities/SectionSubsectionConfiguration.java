package com.pransquare.dashboard.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "section_subsection_configuration")
public class SectionSubsectionConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    // Foreign key to section (code)
    @Column(name = "section_code", nullable = false)
    private String sectionCode;

    // Foreign key to subsection (code)
    @Column(name = "subsection_code", nullable = false)
    private String subsectionCode;

    // Status of the configuration, default is "Active"
    @Column(name = "status", nullable = false)
    private String status = "Active"; // Default status

    

    // Many-to-one relationship with TdsSection
    @ManyToOne
    @JoinColumn(name = "section_code", referencedColumnName = "code", insertable = false, updatable = false)
    private TdsSection section;

    // Many-to-one relationship with TdsSubSection
    @ManyToOne
    @JoinColumn(name = "subsection_code", referencedColumnName = "code", insertable = false, updatable = false)
    private TdsSubSection subsection;

    public SectionSubsectionConfiguration() {
    }
    
    public SectionSubsectionConfiguration(String sectionCode, String subsectionCode, String status) {
        this.sectionCode = sectionCode;
        this.subsectionCode = subsectionCode;
        this.status = status;
    }

    // Getters and Setters
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

    public String getSubsectionCode() {
        return subsectionCode;
    }

    public void setSubsectionCode(String subsectionCode) {
        this.subsectionCode = subsectionCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TdsSection getSection() {
        return section;
    }

    public void setSection(TdsSection section) {
        this.section = section;
    }

    public TdsSubSection getSubsection() {
        return subsection;
    }

    public void setSubsection(TdsSubSection subsection) {
        this.subsection = subsection;
    }
}
