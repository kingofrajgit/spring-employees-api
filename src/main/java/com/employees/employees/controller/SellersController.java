package com.employees.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.SellersInfoDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.service.SellersService;

@RestController
public class SellersController {
	
	@Autowired
	SellersService service;
	
	@PostMapping("sellers/registration")
	public ResponseEntity<?> registration(@RequestBody SellersInfoDTO sellersDto){
		try {
			service.registration(sellersDto);
		}catch(ValidatorException e) {
			
		}
		return null;
		
	}

}
