//package com.hackathon.service;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.hackathon.dao.ComplaintRepo;
//import com.hackathon.dao.DeptRepository;
//import com.hackathon.dao.UserRepository;
//import com.hackathon.entity.Complaint;
//import com.hackathon.entity.Department;
//import com.hackathon.entity.User;
//import com.hackathon.exceptions.ResourceNotFoundException;
//
//@Service
//public class ComplaintService {
//
//
//	@Autowired
//	private ComplaintRepo repository;
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private DeptRepository deptRepo;
//	
//	public Complaint createComp(Complaint complaint,Integer userId,Integer deptId) {
//			
//		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
//		Department department=deptRepo.findById(deptId).orElseThrow(()->new ResourceNotFoundException("Department","id",deptId));
//		
//		complaint.setAddDate(new Date());
//		complaint.setUser(user);
//		complaint.setDepartment(department);
//		complaint.setStatus("Submited");
//		Complaint newComp=this.repository.save(complaint);
//		System.out.println("..............");
//		return newComp;
//	}
////	
////	public Complaint updateDept(Complaint complaint,Integer dId) {
////		Complaint comp= repository.findById(dId).orElseThrow(()->new ResourceNotFoundException("department","id",dId));
////		dpt.setName(dept.getName());
////		
////		Complaint updatedComp =repository.save(comp);
////		return updatedComp;
////	}
////	
////	public void deleteDept(Integer dId) {
////		Department dpt= repository.findById(dId).orElseThrow(()->new ResourceNotFoundException("department","id",dId));
////		repository.delete(dpt);
////	}	
////	
////	public Department getComplaint(Integer dId) {
////		Department dpt= repository.findById(dId).orElseThrow(()->new ResourceNotFoundException("department","id",dId));
////		return dpt;
////	}	
////
////	public List<Department> getAllComplaint() {
////		List<Department> dpt= repository.findAll();
////		return dpt;
////	}	
////
////	public List<Department> getCompByDepartment(Integer dId) {
////		List<Department> dpt= repository.findAll();
////		return dpt;
////	}	
////
////
////	public List<Department> getCompByUser(Integer uId) {
////		List<Department> dpt= repository.findAll();
////		return dpt;
////	}	
////
////	public List<Department> searchComplaint(String keyword) {
////		List<Department> dpt= repository.findAll();
////		return dpt;
////	}	
//}
