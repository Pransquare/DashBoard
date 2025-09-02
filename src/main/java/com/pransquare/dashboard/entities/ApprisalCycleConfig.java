package com.pransquare.dashboard.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apprisal_cycle_config")
public class ApprisalCycleConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "year_start", nullable = false)
    private LocalDate yearStart;

    @Column(name = "year_end", nullable = false)
    private LocalDate yearEnd;

    @Column(name = "apprisal_type", nullable = false)
    private ApprisalType apprisalType;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "goal_setup_period", nullable = false)
    private Integer goalSetupPeriod;

    @Column(name = "apprisal_initiating_period", nullable = false)
    private Integer apprisalInitiatingPeriod;

    @Column(name = "self_rating_period", nullable = false)
    private Integer selfRatingPeriod;

    @Column(name = "manager_rating_period", nullable = false)
    private Integer managerRatingPeriod;

    @Column(name = "alligible_period", nullable = false)
    private Integer alligiblePeriod;

    public enum ApprisalType {
        ANNUALLY,
        QUARTERLY,
        HALFYEARLY
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getYearStart() {
        return yearStart;
    }

    public void setYearStart(LocalDate yearStart) {
        this.yearStart = yearStart;
    }

    public LocalDate getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(LocalDate yearEnd) {
        this.yearEnd = yearEnd;
    }

    public ApprisalType getApprisalType() {
        return apprisalType;
    }

    public void setApprisalType(ApprisalType apprisalType) {
        this.apprisalType = apprisalType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getGoalSetupPeriod() {
        return goalSetupPeriod;
    }

    public void setGoalSetupPeriod(Integer goalSetupPeriod) {
        this.goalSetupPeriod = goalSetupPeriod;
    }

    public Integer getApprisalInitiatingPeriod() {
        return apprisalInitiatingPeriod;
    }

    public void setApprisalInitiatingPeriod(Integer apprisalInitiatingPeriod) {
        this.apprisalInitiatingPeriod = apprisalInitiatingPeriod;
    }

    public Integer getSelfRatingPeriod() {
        return selfRatingPeriod;
    }

    public void setSelfRatingPeriod(Integer selfRatingPeriod) {
        this.selfRatingPeriod = selfRatingPeriod;
    }

    public Integer getManagerRatingPeriod() {
        return managerRatingPeriod;
    }

    public void setManagerRatingPeriod(Integer managerRatingPeriod) {
        this.managerRatingPeriod = managerRatingPeriod;
    }

    public Integer getAlligiblePeriod() {
        return alligiblePeriod;
    }

    public void setAlligiblePeriod(Integer alligiblePeriod) {
        this.alligiblePeriod = alligiblePeriod;
    }

}
