package com.employees.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.MessageDTO;
import com.employees.employees.model.Salary;
import com.employees.employees.repository.SalaryRepository;
import com.employees.employees.service.SalaryService;

import io.micrometer.core.instrument.config.validate.ValidationException;

@RestController
public class SalaryController {
	
	@Autowired
	SalaryRepository salaryRepository;
	
	@Autowired
	SalaryService  salaryService;
	
	@PostMapping("salary/save")
	public ResponseEntity<?> save(@RequestBody Salary salary) throws ValidationException{
		try {
			salaryService.save(salary);
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
		catch(DataAccessException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping ("salary/update")
	public ResponseEntity<?> update(@RequestParam("empId")Integer empId, @RequestParam("salary") Integer salary,@RequestParam("status") String status){
		String res = null;
		try {
		salaryService.update(empId,salary,status);
		res = "success";
		MessageDTO message = new MessageDTO(res);
		return new ResponseEntity<>(message.getMessage(),HttpStatus.OK);

		}catch(Exception e) {
			res = "unSuccess";
			MessageDTO message = new MessageDTO(res);
			return new ResponseEntity<>(message.getMessage(),HttpStatus.BAD_REQUEST);

		}
		
		
	}

}
