package com.employees.employees.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.MessageDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.EmployeeInformation;
import com.employees.employees.service.EmployeesDetails;


@RestController
public class VerificationControll {
	@Autowired
	EmployeesDetails service;
	
	@GetMapping("employees/document/verification")
	public ResponseEntity<?> docmentVrification(){
		try {
		List<EmployeeInformation> list = service.getAllEmployeesDetails();
		return new ResponseEntity<>(list,HttpStatus.OK);
		}catch(ValidatorException e) {
			MessageDTO message  = new MessageDTO(e.getMessage());
		return new ResponseEntity<>(message,HttpStatus.OK);
		}
	}
}
