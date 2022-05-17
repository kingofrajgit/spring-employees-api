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
@Entity
@ToString
@Table(name = "salary_Sheet")
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_no")
	private Integer sNo;

	@Column(name = "emp_id", nullable = false)
	private Integer empId;

	@Column(name = "designation", nullable = false)
	private String designation;

	@Column(name = "working_days", nullable = false)
	private Integer workingDays;

	@Column(name = "month", nullable = false)
	private Integer month;

	@Column(name = "salary", nullable = false)
	private Integer salary;

	@Column(name = "salary_status", nullable = false)
	private String salaryStatus;

}
