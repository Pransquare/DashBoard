package com.pransquare.dashboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "goals")
public class GoalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Integer goalId;

    @Column(name = "goal_code", nullable = false, length = 200)
    private String goalCode;

    @Column(name = "goal", nullable = false, length = 200)
    private String goal;

    // Constructors
    public GoalEntity() {
    }

    public GoalEntity(String goalCode, String goal) {
        this.goalCode = goalCode;
        this.goal = goal;
    }

    // Getters and Setters
    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public String getGoalCode() {
        return goalCode;
    }

    public void setGoalCode(String goalCode) {
        this.goalCode = goalCode;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    // toString method
    @Override
    public String toString() {
        return "Goal{" +
                "goalId=" + goalId +
                ", goalCode='" + goalCode + '\'' +
                ", goal='" + goal + '\'' +
                '}';
    }
}
