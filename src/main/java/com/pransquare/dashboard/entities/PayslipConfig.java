package com.pransquare.dashboard.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PayslipConfig")
public class PayslipConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(name = "amount_name", nullable = false)
    private String amountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "amount_type", nullable = false)
    private AmountType amountType;

    @Column(nullable = false)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private String currency;

    public enum Status {
        ACTIVE, INACTIVE
    }

    public enum AmountType {
        ADDITION, DEDUCTION
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAmountName() {
        return amountName;
    }

    public void setAmountName(String amountName) {
        this.amountName = amountName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

}
