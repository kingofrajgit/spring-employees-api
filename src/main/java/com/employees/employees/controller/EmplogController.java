package com.employees.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.MessageDTO;
import com.employees.employees.model.Emplogin;
import com.employees.employees.service.emplogService;



@RestController
public class EmplogController {
	
	@Autowired
	emplogService emplogservice;
	
	@PostMapping("emplogin/login")
	public  ResponseEntity<?> emplog(@RequestBody Emplogin emplogin)
	{
		Emplogin response = null;
		try {
			response=emplogservice.emplogin(emplogin.getEmpEmail(),emplogin.getEmpPassword());
			System.out.println(response);
			
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			//e.printStackTrace();
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
}

