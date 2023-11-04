package com.hackathon.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int c_id;
	private String descripation;
	private String status;
	private Date addDate;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Department department;

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaint(int c_id, String descripation, String status, User user) {
		super();
		this.c_id = c_id;
		this.descripation = descripation;
		this.status = status;
		this.user = user;
	}

	public Complaint(int c_id, String descripation, String status, Date addDate, User user, Department department) {
		super();
		this.c_id = c_id;
		this.descripation = descripation;
		this.status = status;
		this.addDate = addDate;
		this.user = user;
		this.department = department;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getDescripation() {
		return descripation;
	}

	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Complaint [c_id=" + c_id + ", descripation=" + descripation + ", status=" + status + ", addDate="
				+ addDate + ", user=" + user + ", department=" + department + "]";
	}	
}