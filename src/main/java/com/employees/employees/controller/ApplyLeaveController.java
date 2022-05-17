package com.employees.employees.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.employees.employees.repository.ApplyLeaveRepository;
import com.employees.employees.model.ApplyLeave;
import com.employees.employees.service.ApplyLeaveService;
import com.employees.employees.dto.MessageDTO;

@RestController
public class ApplyLeaveController {
	
	@Autowired
	ApplyLeaveRepository applyLeaveRepository;
	
	@Autowired
	ApplyLeaveService applyLeaveService;
	@PostMapping("applyleave/insert") // register details will be insert
	public ResponseEntity  <String> save(@RequestBody ApplyLeave applyLeave){
		try {
			applyLeaveService.save(applyLeave);
			return new ResponseEntity<String> (HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("applyLeave/list") // list all users
	public List<ApplyLeave> findAll() {
		List<ApplyLeave> applyLeavelist = null;
		try {
			applyLeavelist=applyLeaveService.findAll();
			}catch(Exception e) {
				e.getMessage();
			}
		return applyLeavelist;
	}
	@DeleteMapping("applyleave/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		applyLeaveRepository.deleteById(id);
		
	}
	@GetMapping("applyleave/accept")
	public ResponseEntity<?> accept (@RequestParam("id") Integer id){
		try {
			applyLeaveRepository.applicationStatusAccept(id);
			return new ResponseEntity<> (HttpStatus.OK);
		}catch(Exception e) {
			MessageDTO message=new MessageDTO(e.getMessage());
			return new ResponseEntity<> (message,HttpStatus.BAD_REQUEST);
		}
		}
	@GetMapping("applyleave/reject")
	public ResponseEntity<?> reject (@RequestParam("id") Integer id){
		try {
			String status = "REJECTED"; 
			applyLeaveRepository.applicationStatusReject(id,status);
			return new ResponseEntity<> (HttpStatus.OK);
		}catch(Exception e) {
			MessageDTO message=new MessageDTO(e.getMessage());
			return new ResponseEntity<> (message,HttpStatus.BAD_REQUEST);
		
		}
		}
	
	
}

	
	

