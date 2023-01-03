package com.core;

import java.time.LocalDate;

public class Task {
//	You can create a class Task with fields like taskId, taskName, description, taskDate, status, active.
//	taskId should be unique and generated automatically.
//	status should be either PENDING, IN PROGRESS or COMPLETED.
//	active should be either true or false. Deleted task will have active=false
//	Newly added task should have default status as PENDING and active=true

	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private TaskStatus status;
	private boolean active;
	private static int taskIdCounter;

	static {
		taskIdCounter = 100;
	}

	public Task(int taskId, String taskName, String description, LocalDate taskDate, TaskStatus status,
			boolean active) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
	}

	public Task(String taskName, String description) {
		this.taskId = taskIdCounter;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = LocalDate.now();
		this.status = TaskStatus.PENDING;
		this.active = true;
		taskIdCounter++;
	}

	@Override
	public String toString() {
		return String.format("TaskId:%-7dTaskName:%-10sDescription:%-15sTaskDate:%-15sStatus:%-10sActive:%-10s",
				taskId, taskName, description, taskDate, status, active);
	}
	

	public String writeToFile() {
		return taskId+","+taskName+","+description+","+taskDate+","+status+","+active;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getTaskName() {
		return taskName;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	
	
}
