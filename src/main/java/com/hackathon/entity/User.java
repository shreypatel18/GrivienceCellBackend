package com.hackathon.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Name field is required")
	@Size(min = 2, message = "Enter name properly")
	@Column(unique = true)
	private String name;
	
	@Column(unique = true)
	private String email;
	@NotBlank
	private String password;
	private String role;
	private String imgUrl;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
	private List<Complaint> Complaints= new ArrayList<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id,
			@NotBlank(message = "Name field is required") @Size(min = 2, message = "Enter name properly") String name,
			String email, String password, String role, String imgUrl, List<Complaint> complaints) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.imgUrl = imgUrl;
		Complaints = complaints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<Complaint> getComplaints() {
		return Complaints;
	}

	public void setComplaints(List<Complaint> Complaints) {
		this.Complaints = Complaints;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", imgUrl=" + imgUrl + ", Complaints=" + Complaints + "]";
	}	
}
