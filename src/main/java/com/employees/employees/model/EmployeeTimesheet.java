package com.employees.employees.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee_timesheet")
public class EmployeeTimesheet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "s_no")
	private int sNo;

	@Column(name = "emp_id")
	private String employeeId;

	@Column(name = "emp_name")
	private String employeeName;
	
	@Column(name="date")
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate date = LocalDate.now();;

	@Column(name = "task")
	private String task;

	@Column(name = "working_hours")
	private String workingHours;

	@Column(name = "leaving_hours")
	private String leavingHours;

	
}