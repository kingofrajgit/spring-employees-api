package com.employees.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.Emplogin;
import com.employees.employees.model.EmployeeInformation;
import com.employees.employees.repository.EmpInfoRepositry;
import com.employees.employees.repository.EmplogRepositry;
import com.employees.employees.validation.emplogValidation;

@Configuration
@Service
public class emplogService {
	@Autowired
	EmplogRepositry emplogrepositry;
	@Autowired
	EmpInfoRepositry empinforepositry;

	public Emplogin emplogin(String email, String password) throws Exception {
		emplogValidation.logvalidation(email, password);
		Emplogin user = null;
		EmployeeInformation list = null;
		
		try {
			user = emplogrepositry.findByempEmail(email);
			if (user == null) {
				throw new Exception("Not a Registered Employee");
			} else if (user.getEmpPassword().equals(password)) {
				return user;
			} else {
				throw new Exception("Invalid credentials");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String passwordupdate(Integer id, String password) throws Exception {
		String list = null;
		try {
			emplogValidation.passwordcheck(id, password);
			emplogrepositry.updatepassword(id, password);
			list = "successfully updated";
		} catch (DataAccessException e) {
			throw new ValidatorException(e.getMessage());
		}
		return list;
	}

}
