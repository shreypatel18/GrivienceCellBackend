package com.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.hackathon.dao.UserRepository;
import com.hackathon.entity.User;
import com.hackathon.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User createUser(User user) {
		User u =repository.save(user);
		return u;
	}
	
	public User getUserById(Integer userId) {
		User user= this.repository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		return user;
	}
	
	public User updateUser(User u,Integer userId) {
		User user= repository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		user.setName(u.getName());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		
		User updatedUser=this.repository.save(user);
		return updatedUser;
	}
	
	public List<User> getAllUsers(){
		List<User> users =repository.findAll();
		return users;
	}
	public void deleteUser(Integer userId) {
		User user= repository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		repository.delete(user);
	}
}
