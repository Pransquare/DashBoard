package com.pransquare.dashboard.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tds_regime_master")
public class TdsRegimeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String regimeDescription;
    private String status;

    // Constructors
    public TdsRegimeMaster() {
    }

    public TdsRegimeMaster(String code, String regimeDescription, String status) {
        this.code = code;
        this.regimeDescription = regimeDescription;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public String getRegimeDescription() {
        return regimeDescription;
    }

    public void setRegimeDescription(String regimeDescription) {
        this.regimeDescription = regimeDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
