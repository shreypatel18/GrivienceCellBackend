//package com.hackathon.restcontroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hackathon.entity.Complaint;
//import com.hackathon.service.ComplaintService;
//
//@RestController
//@RequestMapping("/api")
//public class ComplaintController {
//
//	@Autowired
//	private ComplaintService compService;
//	
//	@PostMapping("/user/{userId}/department/{dId}/complaints")
//	public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint,
//			@PathVariable("userId") Integer userid,@PathVariable("dId") Integer dId){
//		Complaint comp=compService.createComp(complaint, userid, dId);
//		return new ResponseEntity<Complaint>(comp,HttpStatus.CREATED);
//	}
//}
