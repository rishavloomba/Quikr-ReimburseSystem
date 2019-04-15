package com.quikr.requests;

public class FinanceUpdate {
	private int id;
	private int taskid;
	public FinanceUpdate() {
		
	}
	public FinanceUpdate(int id, int taskid) {
		super();
		this.id = id;
		this.taskid = taskid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	
	

}