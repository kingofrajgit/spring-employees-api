package com.employees.employees.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employees.employees.model.EmployeeInformation;

@Repository
public interface EmpInfoRepositry extends JpaRepository<EmployeeInformation, Integer> {

	@Transactional
	@Modifying
	@Query("update EmployeeInformation e set  e.status=:status where e.empId=:id")
	void docmentVrificationUpdate(@Param("id") Integer id, @Param("status") String status);

	@Query("select e from EmployeeInformation e where e.status=:status")
	List<EmployeeInformation> findbyStatus(String status) throws SQLException;

}
