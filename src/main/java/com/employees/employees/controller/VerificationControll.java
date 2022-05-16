package com.employees.employees.controller;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employees.dto.MessageDTO;
import com.employees.employees.dto.ValidateResultDTO;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.EmployeeInformation;
import com.employees.employees.service.empDocumentValidationService;

@RestController
public class VerificationControll {
	@Autowired
	empDocumentValidationService service;

	/**
	 * this method used to get all verified status details
	 * 
	 * @return
	 */
	@GetMapping("employees/document/verification")
	public ResponseEntity<?> docmentVrification() {
		try {
			List<EmployeeInformation> list = service.getAllEmployeesDetails();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (ValidatorException e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
	}

	/**
	 * this method used to update verification status
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@GetMapping("employees/document/verificationUpdate")
	public ResponseEntity<?> docmentVrificationUpdate(@RequestParam("empId") Integer id,
			@RequestParam("status") String status) {
		try {
			String list = service.docmentVrificationUpdate(id, status);
			MessageDTO message = new MessageDTO(list);
			return new ResponseEntity<>(message.getMessage(), HttpStatus.OK);
		} catch (ValidatorException e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
	} 
	
	/**
	 * this method used  to get all verified status data
	 * @param status
	 * @return
	 * @throws SQLException
	 */

	@GetMapping("employees/document/getAllDocumentsByVerifiedStaus")
	public ResponseEntity<?> getAllDocumentsByVerifiedStaus(@RequestParam("status") String status) throws SQLException {
		try {
			List<EmployeeInformation> list = service.getAllEmployeesDetails(status);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
	}
	
	/**
	 * this method used verify documents
	 * @return
	 */
	@GetMapping("employees/document/verificationlist")
	public ResponseEntity<?> Verifcation() {
		try {
			List<ValidateResultDTO> list = service.getEmployeesDetails();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (ValidatorException e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
	}
	
}
