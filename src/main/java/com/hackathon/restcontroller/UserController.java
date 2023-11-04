package com.hackathon.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hackathon.dao.UserRepository;
import com.hackathon.entity.User;
import com.hackathon.exceptions.ApiResponse;
import com.hackathon.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user,Errors errors) {
		
		try {
			if(repository.existsByNameOrEmail(user.getName(), user.getEmail()))
				throw new Exception("Name already taken");
			if(errors.hasErrors()) {
				System.out.println(errors);
                return ResponseEntity.badRequest().body("Validation errors: " + errors.getAllErrors());
			}
				
			System.out.println(user);
			user.setRole("ROLE_USER");
			user.setPassword((user.getPassword()));
			User result=service.createUser(user);
			System.out.println(result);

            return ResponseEntity.status(HttpStatus.CREATED).body("User created: " + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("userId") Integer uId){
		User updatedUser=service.updateUser(user, uId);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId){
		service.deleteUser(uId);
        return new ResponseEntity(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(this.service.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable("userId") Integer uId){
		return ResponseEntity.ok(this.service.getUserById(uId));
	}
}