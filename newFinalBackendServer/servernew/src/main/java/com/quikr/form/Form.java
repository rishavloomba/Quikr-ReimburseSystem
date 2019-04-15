package com.quikr.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Tform")
public class Form {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="formid")
	private int formid;
	
	@Column(name="empid")
	private int empid;
	
	@Column(name="managerid")
	private int managerid;
	
	@Column(name="total_exp")
	private int total_exp;

	@Column(name="status")
	private String status;
	
	
	public Form() {
		
	}
    public Form(int empid,int managerid,int total_exp,String status) {
    	this.empid=empid;
    	this.managerid=managerid;
    	this.total_exp=total_exp;
    	this.status=status;
    		
    }
	public Form(int formid, int empid, int managerid, int total_exp,String status) {
		super();
		this.formid = formid;
		this.empid = empid;
		this.managerid = managerid;
	
		this.total_exp = total_exp;
		this.status=status;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFormid() {
		return formid;
	}

	public void setFormid(int formid) {
		this.formid = formid;
	}
   //@JsonProperty("empid")
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
	
	

}
