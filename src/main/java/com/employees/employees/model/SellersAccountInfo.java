package com.employees.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seller_account_info")
public class SellersAccountInfo {
	
	@Id
	@Column(name = "account_id")
	Integer accountId = 0;
	
	@Column(name = "aadhar_number")
	long aadharNumber = 0;
	
	@Column(name = "pan_number")
	String panNumber = null;
	
	@Column(name = "bank_name")
	String bankName = null;
	
	@Column(name = "account_number")
	long accountNumber = 0;
	
	@Column(name = "ifsc_code")
	String ifscCode = null;
}
