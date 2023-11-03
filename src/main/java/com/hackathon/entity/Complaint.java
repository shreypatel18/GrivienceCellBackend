package com.hackathon.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int c_id;
	
	private String descripation;
	private String status;
	@ManyToOne
	private User user;
	
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

	@Override
	public String toString() {
		return "Complaint [c_id=" + c_id + ", descripation=" + descripation + ", status=" + status + ", user=" + user
				+ "]";
	}
	
}