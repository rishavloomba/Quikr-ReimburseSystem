package com.quikr.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Emp {
	
	@Id
	@Column(name="empid")
	private int empid;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="contact_no")
	private String contact_no;
	
	@Column(name="location")
	private String location;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="manager_id")
	private int mngId;

   public Emp() {
		
	}
	
	

	public Emp(int empid, String userName, String email, String password, String contactNo, String location,
			String designation, int mngId) {
		super();
		this.empid = empid;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.contact_no = contact_no;
		this.location = location;
		this.designation = designation;
		this.mngId = mngId;
	}



	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contact_no;
	}

	public void setContactNo(String contactNo) {
		this.contact_no = contact_no;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getMngId() {
		return mngId;
	}

	public void setMngId(int mngId) {
		this.mngId = mngId;
	}
	
	

}
