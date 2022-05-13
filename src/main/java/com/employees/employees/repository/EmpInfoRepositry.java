package com.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employees.employees.model.EmployeeInformation;




@Repository
public interface EmpInfoRepositry extends JpaRepository<EmployeeInformation,Integer> {
	

}
