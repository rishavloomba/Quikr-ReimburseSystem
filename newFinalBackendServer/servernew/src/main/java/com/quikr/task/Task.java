package com.quikr.task;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
/*
@Entity
//@Table(name="tasks")
@Table(name="Tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="taskid")
	private int taskid;
	
	@Column(name="empid")
	 private int empid;
	
	@Column(name="managerid")
	private int managerid;
	
	@Column(name="travel_exp")
	
	private int travel_exp;
	
	@Column(name="telephone_exp")
	
	private int telephone_exp;
	
	@Column(name="business_meal")
	
	private int business_meal;
	
	@Column(name="hotel_stay")
	
	private int hotel_stay;
	
	@Column(name="total_exp")
	private int total_expense;

	@Column(name="description")
	private String description;
	
	@Column(name="published_date")
	private Date published_date;
	
	@Column(name="status")
	private String status;
	
	@Column(name="expense_date")
	private Date expense_date;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="updated_date")
	private Date updated_date;
	
	@Column(name="published")
	private boolean published;
	
	@Column(name="paid")
	private boolean paid;

	public Task() {
		
	}
	 public Task(int empid, int managerid, int travel_exp, int telephone_exp, int business_meal, int hotel_stay,
			int total_expense, String description, Date published_date, String status,Date created_date,Date updated_date,boolean published,boolean paid,Date expense_date) {
		super();
		
		this.empid = empid;
		this.managerid = managerid;
		this.travel_exp = travel_exp;
		this.telephone_exp = telephone_exp;
		this.business_meal = business_meal;
		this.hotel_stay = hotel_stay;
		this.total_expense = total_expense;
		this.description = description;
		this.published_date = published_date;
		this.status = status;
		this.expense_date=expense_date;
		this.created_date=created_date;
		this.updated_date=updated_date;
		this.published=published;
		this.paid=paid;  
	}

		public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
		public int getTaskid() {
			return taskid;
		}
		public void setTaskid(int taskid) {
			this.taskid = taskid;
		}

	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	
	public Date getExpense_date() {
		return expense_date;
	}
	public void setExpense_date(Date expense_date) {
		this.expense_date = expense_date;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
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
    
	
	public int getTravel_exp() {
		return travel_exp;
	}

	public void setTravel_exp(int travel_exp) {
		this.travel_exp = travel_exp;
	}

	public int getTelephone_exp() {
		return telephone_exp;
	}

	public void setTelephone_exp(int telephone_exp) {
		this.telephone_exp = telephone_exp;
	}

	public int getBusiness_meal() {
		return business_meal;
	}

	public void setBusiness_meal(int business_meal) {
		this.business_meal = business_meal;
	}

	public int getHotel_stay() {
		return hotel_stay;
	}

	public void setHotel_stay(int hotel_stay) {
		this.hotel_stay = hotel_stay;
	}

	public int getTotal_expense() {
		return total_expense;
	}

	public void setTotal_expense(int total_expense) {
		this.total_expense = total_expense;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublished_date() {
		return published_date;
	}

	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

}*/

@Entity
//@Table(name="tasks")
@Table(name="Tasks")
public class Task {
    @Column(name="formid")
    private int formid; 
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="taskid")
	private int taskid;
	
	@Column(name="empid")
	 private int empid;
	
	@Column(name="managerid")
	private int managerid;
	
	@Column(name="travel_exp")
	
	private int travel_exp;
	
	@Column(name="telephone_exp")
	
	private int telephone_exp;
	
	@Column(name="business_meal")
	
	private int business_meal;
	
	@Column(name="hotel_stay")
	
	private int hotel_stay;
	
	@Column(name="total_exp")
	private int total_expense;

	@Column(name="description")
	private String description;
	
	@Column(name="published_date")
	private Date published_date;
	
	@Column(name="status")
	private String status;
	
	@Column(name="expense_date")
	private Date expense_date;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="updated_date")
	private Date updated_date;
	
	@Column(name="published")
	private boolean published;
	

	public Task() {
		
	}
	 public Task(int empid, int managerid, int travel_exp, int telephone_exp, int business_meal, int hotel_stay,
			int total_expense, String description, Date published_date, String status,Date created_date,Date updated_date,boolean published,boolean paid,Date expense_date) {
		super();
		
		this.empid = empid;
		this.managerid = managerid;
		this.travel_exp = travel_exp;
		this.telephone_exp = telephone_exp;
		this.business_meal = business_meal;
		this.hotel_stay = hotel_stay;
		this.total_expense = total_expense;
		this.description = description;
		this.published_date = published_date;
		this.status = status;
		this.expense_date=expense_date;
		this.created_date=created_date;
		this.updated_date=updated_date;
		this.published=published;
		//this.paid=paid;  
	}

		
		public int getTaskid() {
			return taskid;
		}
		public void setTaskid(int taskid) {
			this.taskid = taskid;
		}

	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	
	public Date getExpense_date() {
		return expense_date;
	}
	public void setExpense_date(Date expense_date) {
		this.expense_date = expense_date;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	@JsonProperty("empid")
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
  
	
	public int getTravel_exp() {
		return travel_exp;
	}

	public void setTravel_exp(int travel_exp) {
		this.travel_exp = travel_exp;
	}

	public int getTelephone_exp() {
		return telephone_exp;
	}

	public void setTelephone_exp(int telephone_exp) {
		this.telephone_exp = telephone_exp;
	}

	public int getBusiness_meal() {
		return business_meal;
	}

	public void setBusiness_meal(int business_meal) {
		this.business_meal = business_meal;
	}

	public int getHotel_stay() {
		return hotel_stay;
	}

	public void setHotel_stay(int hotel_stay) {
		this.hotel_stay = hotel_stay;
	}

	public int getTotal_expense() {
		return total_expense;
	}

	public void setTotal_expense(int total_expense) {
		this.total_expense = total_expense;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublished_date() {
		return published_date;
	}

	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
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

}