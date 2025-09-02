package com.pransquare.dashboard.models;

public class GoalsSetupModel {

	private String goalType;
	private String goal;
	private String goalDescription;
	private String status;
	private Integer id;

	public String getGoalType() {
		return goalType;
	}

	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getGoalDescription() {
		return goalDescription;
	}

	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GoalsSetupModel [goalType=" + goalType + ", goal=" + goal + ", goalDescription="
				+ goalDescription + ", status=" + status + ", id=" + id + "]";
	}

}
