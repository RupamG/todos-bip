package com.bip.todo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Todo")
public class Todo {
	@Id
	@Column(name = "task_id")
	private int taskId;
	@Column(name = "task_desc")
    private String taskDesc;
	@Column(name = "task_status")
    private String taskStatus;
	public Todo() {}
	public Todo(int taskId, String taskDesc, String taskStatus) {
		super();
		this.taskId = taskId;
		this.taskDesc = taskDesc;
		this.taskStatus = taskStatus;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	
	
}
