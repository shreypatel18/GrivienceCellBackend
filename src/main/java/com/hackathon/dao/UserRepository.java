package com.hackathon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
