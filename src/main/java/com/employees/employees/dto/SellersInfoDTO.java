package com.employees.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SellersInfoDTO {
	
	private Integer sellersId = 0;
	
	private Integer accountId = 0;

	private String  sellersName = null ;

	private long mobileNumber =0 ;

	private String gender = null;

	private String categorie = null;

	private String branchName = null;

	private String address =null ;

	private String city = null;

	private Integer pincode = 0;
}
