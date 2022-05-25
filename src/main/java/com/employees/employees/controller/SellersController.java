package com.employees.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.SellersInfoDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.Sellers;
import com.employees.employees.service.SellersService;

@RestController
public class SellersController {
	
	@Autowired
	SellersService service;
	
	@PostMapping("sellers/registration")
	public ResponseEntity<?> registration(@RequestBody SellersInfoDTO sellersDto){
		try {
			sellersDto = service.registration(sellersDto);
			return new ResponseEntity<>(sellersDto,HttpStatus.OK);
		}catch(ValidatorException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("sellers/get/details")
	public ResponseEntity<?> getDetails(){
		try {
			List<Sellers> sellers = service.getDetails();
			return new ResponseEntity<>(sellers,HttpStatus.OK);
		}catch(ValidatorException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
