package com.employees.employees.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.EmployeeInformation;
import com.employees.employees.repository.EmpInfoRepositry;
import com.employees.employees.validation.EmpDocumentValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class empDocumentValidationService {

	@Autowired
	EmpInfoRepositry empinforepositry;

	@Autowired
	EmpDocumentValidation validator;

	public List<EmployeeInformation> getAllEmployeesDetails() throws ValidatorException {
		List<EmployeeInformation> list = null;
		try {

			list = empinforepositry.findAll();
			if (list.isEmpty()) {
				log.error("no records fount in employees details");
				throw new ValidatorException("no records fount in employees details");
			} else {
				validator.validateDocuments(list);
			}
		} catch (DataAccessException e) {
			throw new ValidatorException(e.getMessage());
		}
		return list;
	}

	public String docmentVrificationUpdate(Integer id, String status) throws ValidatorException {
		String list = null;
		try {
			validator.validate(id, status);
			empinforepositry.docmentVrificationUpdate(id, status);
			list = "success";
		} catch (DataAccessException e) {
			throw new ValidatorException(e.getMessage());
		}
		return list;
	}

	public List<EmployeeInformation> getAllEmployeesDetails(String status) throws ValidatorException, SQLException {
		List<EmployeeInformation> list = null;
		try {

			list = empinforepositry.findbyStatus(status);
			if (list.isEmpty()) {
				log.error("no records fount in employees details");
				throw new ValidatorException("no records fount in employees details");
			}
		} catch (DataAccessException e) {
			throw new ValidatorException(e.getMessage());
		}
		return list;
	}

}
