package com.employees.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.SellersAccountInfoDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.service.SellersAccountInfoService;

@RestController
public class SellersAccoutInfoController {

	@Autowired
	SellersAccountInfoService sevice;

	@PostMapping("sellers/getaccountinfo")
	public ResponseEntity<?> getAccountInfo(@RequestBody SellersAccountInfoDTO dto) {

		try {
			SellersAccountInfoDTO sellersDto = sevice.insert(dto);
			return new ResponseEntity<>(sellersDto, HttpStatus.BAD_REQUEST);
		} catch (ValidatorException e) {
			String result = "invalide account credential";
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
