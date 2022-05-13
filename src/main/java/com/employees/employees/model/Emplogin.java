package com.employees.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
@Table(name="emp_deatils")
public class Emplogin {
	@Id
	@Column(name="emp_id")
	private Integer empId;
	@Column(name="emp_name")
	private String empName;
	@Column(name="emp_email")
	private String empEmail;
	@Column(name="emp_password")
	private String empPassword;
	
	
	

}
