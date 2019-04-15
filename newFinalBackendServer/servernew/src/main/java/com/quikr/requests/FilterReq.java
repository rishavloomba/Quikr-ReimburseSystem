package com.quikr.requests;

public class FilterReq {
	private int id;
	private int month;
	private int year;
	
	public FilterReq() {
		
	}
	public FilterReq(int managerid, int month, int year) {
		super();
		this.id = managerid;
		this.month = month;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int Id) {
		this.id = Id;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	

}
