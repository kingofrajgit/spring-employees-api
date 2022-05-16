package com.employees.employees.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValidateResultDTO {
	
	private String empNameResult;
	
	private String empEmailResult;
	
	private String mobileNumberResult;
	
	private String roleResult;
	
	private String aadharResult;
	
	private String pannumResult;
	
	private String accountNoResult;
	
	private String ifscCodeResult;
	
	private String statusResult;
	
	

}
