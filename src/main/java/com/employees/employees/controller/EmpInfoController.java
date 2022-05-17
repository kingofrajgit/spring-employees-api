package com.employees.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.model.EmployeeInformation;
import com.employees.employees.repository.EmpInfoRepositry;

@RestController
public class EmpInfoController {

	@Autowired
	EmpInfoRepositry empinforepositry;

	@PostMapping("details/employeeinfo")
	public EmployeeInformation Information(@RequestBody EmployeeInformation information) {

		EmployeeInformation apply = empinforepositry.save(information);
		return apply;

	}

	@GetMapping("employeeinformation/listemployee")
	public List<EmployeeInformation> findAllEmployees() {
		List<EmployeeInformation> employeelist = empinforepositry.findAll();
		return employeelist;
	}
}
