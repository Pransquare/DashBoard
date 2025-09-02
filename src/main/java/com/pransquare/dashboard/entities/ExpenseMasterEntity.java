package com.pransquare.dashboard.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_master")
public class ExpenseMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "expense_code", nullable = false, length = 45, unique = true)
    private String expenseCode;

    @Column(name = "expense_desc", nullable = false, length = 200)
    private String expenseDesc;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        this.expenseCode = expenseCode;
    }

    public String getExpenseDesc() {
        return expenseDesc;
    }

    public void setExpenseDesc(String expenseDesc) {
        this.expenseDesc = expenseDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
