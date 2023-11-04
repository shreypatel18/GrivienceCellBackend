package com.hackathon.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.dao.DeptRepository;
import com.hackathon.dao.UserRepository;
import com.hackathon.entity.Department;
import com.hackathon.entity.User;
import com.hackathon.exceptions.ApiResponse;
import com.hackathon.service.DeptService;
import com.hackathon.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dept")
public class DeptController {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DeptRepository repository;
	
	@PostMapping("/")
	public ResponseEntity<String> createUser(@Valid @RequestBody Department dept,Errors errors) {
		
		try {
			if(repository.existsByName(dept.getName()))
				throw new Exception("Department already exist");
			if(errors.hasErrors()) {
				System.out.println(errors);
                return ResponseEntity.badRequest().body("Validation errors: " + errors.getAllErrors());
			}
				
			System.out.println(dept);
			Department result=service.createDept(dept);
			System.out.println(result);

            return ResponseEntity.status(HttpStatus.CREATED).body("Department created: " + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/{dId}")
	public ResponseEntity<Department> updateD(@RequestBody Department dept,@PathVariable("dId") Integer dId){
		Department updatedDpt=service.updateDept(dept, dId);
		return ResponseEntity.ok(updatedDpt);
	}
	
	@DeleteMapping("/{dId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("dId") Integer dId){
		service.deleteDept(dId);
        return new ResponseEntity(new ApiResponse("Department deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Department>> getAllUsers(){
		return ResponseEntity.ok(this.service.getAllDept());
	}
	
	@GetMapping("/{dId}")
	public ResponseEntity<Department> getSingleUser(@PathVariable("dId") Integer dId){
		return ResponseEntity.ok(this.service.getDept(dId));
	}
}
