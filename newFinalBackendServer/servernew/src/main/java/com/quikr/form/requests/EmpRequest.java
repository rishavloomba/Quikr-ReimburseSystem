package com.quikr.form.requests;

import java.util.ArrayList;

import com.quikr.requests.MTask;

public class EmpRequest {
	private int empid;
	private int managerid;
	private int total_exp;
	private ArrayList<MTask> tasks;
	public EmpRequest() {
		
	}
	
	public EmpRequest(int empid, int managerid, int total_exp,ArrayList<MTask> tasks) {
		super();
		this.empid = empid;
		this.managerid = managerid;
		this.total_exp=total_exp;
		this.tasks = tasks;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	
	public int getTotal_exp() {
		return total_exp;
	}

	public void setTotal_exp(int total_exp) {
		this.total_exp = total_exp;
	}

	public ArrayList<MTask> getTasks() {
		return tasks;
	}
	public void setTasks(ArrayList<MTask> tasks) {
		this.tasks = tasks;
	}
	

	

}
