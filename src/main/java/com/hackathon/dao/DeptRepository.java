package com.hackathon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;

public interface DeptRepository extends JpaRepository<Department, Integer>{

	boolean existsByName(String name);
}
