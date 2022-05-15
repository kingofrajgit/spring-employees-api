package com.employees.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "emp_deatils")
public class Emplogin {
	@Id
<<<<<<< HEAD
	@Column(name = "emp_id")
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
>>>>>>> d92e99e63272d2963975d9e9c49ce50e82bfab37
	private Integer empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_email")
	private String empEmail;
	@Column(name = "emp_password")
	private String empPassword;

}
