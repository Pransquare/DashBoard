package com.pransquare.dashboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nationality_document_list")
public class NationalityDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "country_code", nullable = false, length = 200)
    private String countryCode;

    @Column(name = "document", nullable = false, length = 200)
    private String document;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @Column(name = "mandatory", nullable = false)
    private Boolean mandatory;

    // Constructors
    public NationalityDocumentEntity() {
    }

    public NationalityDocumentEntity(String countryCode, String document, String status, Boolean mandatory) {
        this.countryCode = countryCode;
        this.document = document;
        this.status = status;
        this.mandatory = mandatory;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    // toString method
    @Override
    public String toString() {
        return "NationalityDocument{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", document='" + document + '\'' +
                ", status='" + status + '\'' +
                ", mandatory=" + mandatory +
                '}';
    }
}
