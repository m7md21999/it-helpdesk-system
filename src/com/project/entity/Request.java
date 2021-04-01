package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="req")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "req_id")
	private int id;
	
	
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="tech_id" ,nullable = true)
	private Integer tech_id;
		
	@NotNull(message="required!")
	@NotBlank(message="Subject is required!")
	@Size(min=1, message=" atleast 1 digit!")
	@Column(name="subject")
	private String subject;
	
	@Column(name="description")
	private String description;
	
	@NotNull(message="required!")
	@NotBlank(message="required!")
	@Column(name="priority")
	private String priority;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date date;
	
	@Column(name="assignedDate")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date assignedDate;
	
  
	
	public Request(){}
	
	// New Request Created by the emp - status = "new"
	public Request(int id, int emp_id, String subject, String description, String priority, String status, Date date) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.subject = subject;
		this.description = description;
		this.priority = priority;
		this.status = status;
		//this.date = new java.sql.Date(new java.util.Date().getTime());
		this.date = date;
	}
	
	// Assigned Req to A tech - status changed to "Assigned"
	public Request(int id, int emp_id, int tech_id, String subject, String description, String priority, String status,
			Date date) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.tech_id = tech_id;
		this.subject = subject;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.date = date;
	}
	
	public Request(int id, int emp_id, int tech_id, String subject, String description, String priority, String status,
			Date date , Date assignedDate) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.tech_id = tech_id;
		this.subject = subject;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.date = date;
		this.assignedDate = assignedDate;
	}
	
	// Fininshed reqs - stauts changes to "Closed"
//	public Request(int id, int emp_id, int tech_id, int soution_id, String subject, String description, String priority,
//			String status, Date date) {
//		super();
//		this.id = id;
//		this.emp_id = emp_id;
//		this.tech_id = tech_id;
//		this.subject = subject;
//		this.description = description;
//		this.priority = priority;
//		this.status = status;
//		this.date = date;
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getTech_id() {
		return tech_id;
	}
	public void setTech_id(int tech_id) {
		this.tech_id = tech_id;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	
//	public int getSol_id() {
//		return sol_id;
//	}
//
//	public void setSol_id(int sol_id) {
//		this.sol_id = sol_id;
//	}




}
