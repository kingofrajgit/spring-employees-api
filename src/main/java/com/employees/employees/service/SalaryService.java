package com.employees.employees.service;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.employees.employees.model.Salary;
import com.employees.employees.repository.SalaryRepository;
import com.employees.employees.validation.SalaryValidation;

@Service
public class SalaryService {

	@Autowired
	SalaryRepository salaryRepository;


	public void save(Salary salary) throws ValidationException {
		try {
			salaryRepository.save(salary);
		} catch (DataAccessException e) {
			throw new ValidationException(e.getMessage());
		}
	}

	public void update(Integer empId, Integer salary, String status) throws ValidationException {
		try {
			salaryRepository.update(empId, salary, status);
		} catch (DataAccessException e) {
			throw new ValidationException(e.getMessage());

		}
	}

}
