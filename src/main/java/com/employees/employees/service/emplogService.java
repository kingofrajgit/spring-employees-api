package com.employees.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.employees.model.Emplogin;
import com.employees.employees.repository.EmplogRepositry;
import com.employees.employees.validation.emplogValidation;



@Service
public class emplogService {
	@Autowired
	EmplogRepositry emplogrepositry;
	
	public Emplogin emplogin(String email, String password) throws Exception {
		emplogValidation.logvalidation(email, password);
		Emplogin user = null;
		try {
			user = emplogrepositry.findByempEmail(email);
			if(user == null) {
				System.out.println("Unregistered Employee");
				throw new Exception("Not a Registered Employee");
			}
			else if(user.getEmpPassword().equals(password)) {
				System.out.println(user.getEmpName()+" LoggedIn sucessfully");
				return user;
			}
			else {
				throw new Exception("Invalid credentials");
			}
		}
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
}
}
