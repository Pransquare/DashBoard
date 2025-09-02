package com.pransquare.dashboard.models;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.Min;

public class GoalSearchModel {

    @Min(0) // Page number cannot be negative
    private int page = 0;

    @Min(1) // Page size must be at least 1
    private int size = 10;

    private String sortBy = "goal"; // Default sorting field
    private String order = "asc";   // Default sorting order
    private String goal;            // Optional filter

    // Default Constructor
    public GoalSearchModel() {
    }

    // Constructor with all parameters
    public GoalSearchModel(int page, int size, String sortBy, String order, String goal) {
        this.page = Math.max(0, page);
        this.size = Math.max(1, size);
        this.sortBy = (sortBy != null && !sortBy.isBlank()) ? sortBy : "goal";
        this.order = ("desc".equalsIgnoreCase(order)) ? "desc" : "asc";
        this.goal = goal;
    }

    // Getters and Setters
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = Math.max(0, page);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = Math.max(1, size);
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = (sortBy != null && !sortBy.isBlank()) ? sortBy : "goal";
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = ("desc".equalsIgnoreCase(order)) ? "desc" : "asc";
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}


