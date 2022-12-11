package com.employees.employees.dto;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString 
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class SellersAccountInfoDTO {

	Integer accountId = 0;

	long aadharNumber = 0;

	String panNumber = null;

	String bankName = null;

	long accountNumber = 0;

	String ifscCode = null;

}
