package com.employees.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.MessageDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.Emplogin;
<<<<<<< HEAD
=======
import com.employees.employees.model.EmployeeInformation;
>>>>>>> d92e99e63272d2963975d9e9c49ce50e82bfab37
import com.employees.employees.repository.EmplogRepositry;
import com.employees.employees.service.emplogService;




@RestController
public class EmplogController {
	
	@Autowired
	emplogService emplogservice;
	
	@Autowired
	EmplogRepositry emplogrepositry;
	
<<<<<<< HEAD
=======
	@PostMapping("emplogin/employeelogininfo")
	public Emplogin LoginInformation(@RequestBody Emplogin logininformation)
	{
		
		
		Emplogin apply=emplogrepositry.save(logininformation);
		return apply; 
		
	}
	
>>>>>>> d92e99e63272d2963975d9e9c49ce50e82bfab37
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
			
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
	}
	
<<<<<<< HEAD
=======
	@GetMapping("employee/delete/{id}")
	public  String delete(@PathVariable("id") Integer id) 
	{	
		String result = null;
		try {
			emplogrepositry.deleteById(id);
			result ="deleted";
		}catch(Exception e){
			result = e.getMessage();
		}
		return result;
	}
	
	@PostMapping("employees/updatepassword")
	public  ResponseEntity<?> updation(@RequestParam("id") Integer id,
			@RequestParam("password") String password) throws Exception {
		try {
			String info =emplogservice.passwordupdate(id, password);
			MessageDTO result = new MessageDTO(info);
			return new ResponseEntity<>(result.getMessage(), HttpStatus.OK);
		} catch (ValidatorException e) {
			MessageDTO result = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
>>>>>>> d92e99e63272d2963975d9e9c49ce50e82bfab37
}

