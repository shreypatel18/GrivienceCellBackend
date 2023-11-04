package com.hackathon.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int d_id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "department")
	private List<Employee> employee=new ArrayList<>();
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Complaint> complaints=new ArrayList<>();
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int d_id, String name) {
		super();
		this.d_id = d_id;
		this.name = name;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", name=" + name + ", employee=" + employee + "]";
	}
	
}
