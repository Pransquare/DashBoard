package com.pransquare.dashboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "releaseNotes")
@Entity(name = "releaseNotes")
public class ReleaseNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "uploaded_path")
    private String uploadedPath;

    @Column(name = "release_version")
    private String releaseVersion;

    @Column(name = "release_name")
    private String releaseName;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "fileName")
    private String fileName;

    // Getters and setters for each field

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUploadedPath() {
        return uploadedPath;
    }

    public void setUploadedPath(String uploadedPath) {
        this.uploadedPath = uploadedPath;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
