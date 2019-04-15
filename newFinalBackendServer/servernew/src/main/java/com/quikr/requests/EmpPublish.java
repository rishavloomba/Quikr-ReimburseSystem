package com.quikr.requests;

import java.util.ArrayList;

public class EmpPublish {
	private int empid;
	private ArrayList<Integer> topublish;
	
	public EmpPublish() {
		
	}
	public EmpPublish(int empid, ArrayList<Integer> topublish) {
		super();
		this.empid = empid;
		this.topublish = topublish;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public ArrayList<Integer> getTopublish() {
		return topublish;
	}
	public void setTopublish(ArrayList<Integer> topublish) {
		this.topublish = topublish;
	}
	
    
}
