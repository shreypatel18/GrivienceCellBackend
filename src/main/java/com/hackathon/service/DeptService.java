package com.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dao.DeptRepository;
import com.hackathon.entity.Department;
import com.hackathon.exceptions.ResourceNotFoundException;

@Service
public class DeptService {

	@Autowired
	private DeptRepository repository;
	
	public Department createDept(Department dept) {
		Department dpt=this.repository.save(dept);
		return dpt;
	}
	
	public Department updateDept(Department dept,Integer dId) {
		Department dpt= repository.findById(dId).orElseThrow(()->new ResourceNotFoundException("department","id",dId));
		dpt.setName(dept.getName());
		
		Department updated=repository.save(dpt);
		return dpt;
	}
	
	public void deleteDept(Integer dId) {
		Department dpt= repository.findById(dId).orElseThrow(()->new ResourceNotFoundException("department","id",dId));
		repository.delete(dpt);
	}	
	
	public Department getDept(Integer dId) {
		Department dpt= repository.findById(dId).orElseThrow(()->new ResourceNotFoundException("department","id",dId));
		return dpt;
	}	

	public List<Department> getAllDept() {
		List<Department> dpt= repository.findAll();
		return dpt;
	}	
}
