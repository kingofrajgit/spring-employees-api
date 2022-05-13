package com.employees.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.employees.employees.exception.ValidatorException;
import com.employees.employees.model.EmployeeInformation;
import com.employees.employees.repository.EmpInfoRepositry;

@Service
public class EmployeesDetails {

	@Autowired
	EmpInfoRepositry empinforepositry;

	public List<EmployeeInformation> getAllEmployeesDetails() throws ValidatorException {
		List<EmployeeInformation> list = null;
		try {
			list = empinforepositry.findAll();
			if (list == null) {
				throw new ValidatorException("no records fount in employees details");
			}
		} catch (DataAccessException e) {
			throw new ValidatorException(e.getMessage());
		}
		return list;
	}

}
