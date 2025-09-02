package com.pransquare.dashboard.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "work_location_master")
public class WorkLocationMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "work_location_code", nullable = false, length = 45)
    private String workLocationCode;

    @Column(name = "work_location", nullable = false, length = 200)
    private String workLocation;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    // Constructors
    public WorkLocationMasterEntity() {
    }

    public WorkLocationMasterEntity(String workLocationCode, String workLocation, String status) {
        this.workLocationCode = workLocationCode;
        this.workLocation = workLocation;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkLocationCode() {
        return workLocationCode;
    }

    public void setWorkLocationCode(String workLocationCode) {
        this.workLocationCode = workLocationCode;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "WorkLocationMasterEntity{" +
                "id=" + id +
                ", workLocationCode='" + workLocationCode + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
