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
@Table(name ="sellers_info")
public class Sellers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sellers_id")
	private Integer sellersId = 0;
	
	@Column(name =  "sellers_name")
	private String  sellersName = null ;

	@Column(name = "mobile_number")
	private long mobileNumber =0 ;

	@Column(name =  "gender")
	private String gender = null;

	@Column(name =  "categorie")
	private String categorie = null;

	@Column(name =  "branch_name")
	private String branchName = null;

	@Column(name =  "address")
	private String address =null ;

	@Column(name =  "city")
	private String city = null;

	@Column(name =  "pincode")
	private Integer pincode = 0;

}
