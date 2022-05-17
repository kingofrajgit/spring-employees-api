package com.employees.employees.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.model.EmployeeTimesheet;
import com.employees.employees.repository.EmployeeTimesheetRepository;



@RestController
public class EmployeeTimesheetController {

	@Autowired
	EmployeeTimesheetRepository employeeTimesheetRepository;

	
	@PostMapping("timesheet/register")
	public EmployeeTimesheet employeeTimesheet(@RequestBody EmployeeTimesheet employeeTimesheet) {
		System.out.println(employeeTimesheet);
	EmployeeTimesheet employeeObj = employeeTimesheetRepository.save(employeeTimesheet);
	System.out.println(employeeObj);
	return employeeObj;
	}
	

	@GetMapping("timesheet/listemployeetimesheet")
	public List<EmployeeTimesheet> getAllEmployee() {
		List<EmployeeTimesheet> employeeList = employeeTimesheetRepository.findAll();
		return employeeList;
	}
	

	@GetMapping("timesheet/{emp_name}")
	public List<EmployeeTimesheet> employee(@PathVariable("emp_name") String employeeName){
		List<EmployeeTimesheet> employeeList=null;
		
		try
		{
			employeeList=employeeTimesheetRepository.findByEmployeeName(employeeName);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employeeList;
		
	}
	@GetMapping("timeheet/getworkinghours")
	public void getTime( @RequestParam("employeeName") String employeeName) {
		float employeeList=0;
		try
		{
			employeeList=employeeTimesheetRepository.getWorkingByEmployeeName(employeeName);
			System.out.println(employeeList);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
