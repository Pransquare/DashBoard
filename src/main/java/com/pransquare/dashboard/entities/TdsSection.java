package com.pransquare.dashboard.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tds_section")
public class TdsSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private String description;
    private String status;
//
//     @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<SectionSubsectionConfiguration> subsectionConfigurations;

    // Constructors
    public TdsSection() {
    }

    public TdsSection(String code, String description, String status) {
        this.code = code;
        this.description = description;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//     public List<SectionSubsectionConfiguration> getSubsectionConfigurations() {
//         return subsectionConfigurations;
//     }
//
//     public void setSubsectionConfigurations(List<SectionSubsectionConfiguration> subsectionConfigurations) {
//         this.subsectionConfigurations = subsectionConfigurations;
//     }

    

}
