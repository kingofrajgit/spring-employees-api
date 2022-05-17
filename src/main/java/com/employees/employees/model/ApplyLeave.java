package com.employees.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name="leave_apply")
public class ApplyLeave {
	@Id
	@Column(name="emp_id")
	private Integer empId;
    
    @Column(name="emp_name")
    private String empName;
    

	@Column(name="leave_from_date")
	private String leaveFromDate;
	
	@Column(name="leave_to_date")
	private String leaveToDate;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="status")
	private String status;
	

	
	
}	


