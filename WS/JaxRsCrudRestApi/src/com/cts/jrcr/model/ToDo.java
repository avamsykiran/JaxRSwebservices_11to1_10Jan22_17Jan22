package com.cts.jrcr.model;

import java.io.Serializable;

public class ToDo implements Serializable {

	private Long id;
	private String task;
	private String status;
	
	public ToDo() {
		// TODO Auto-generated constructor stub
	}

	public ToDo(Long id, String task, String status) {
		super();
		this.id = id;
		this.task = task;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
