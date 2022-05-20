package com.employees.employees.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employees.employees.model.EmployeeTimesheet;


@Repository("employeeTimesheetRepository")
public interface EmployeeTimesheetRepository extends JpaRepository<EmployeeTimesheet, Integer> {


	@SuppressWarnings("unchecked")
	EmployeeTimesheet save(EmployeeTimesheet employeeTimesheet);
	

	List<EmployeeTimesheet> findAll();
	
	//Optional<User> findByRole(String role);
//	@Transactional
//	@Modifying
//	@Query("Select u.name from com.timesheetapp.model.User u")
//	List<EmployeeTimesheet> listName();
//	
//	@Transactional
//	@Modifying
//	@Query("UPDATE com.timesheetapp.model.User u SET u.password=password WHERE u.userId = userId")
//	void updatePassword(@Param("userId") Integer userId,@Param("password") String password);
	//String updatePassword(String email, String password);

	//List<String> findByEmployeeNameAndEmployeeId(String employeeName,String employeeId);

	//List<EmployeeTimesheet> findByName(String employeeName);

	// List<EmployeeTimesheet> findByName(String employeeName);
	
//    @Query(value="SELECT SUM(working_hours) FROM employee_timesheet")
//    public Integer selectTotals();
    
	
	@Query("SELECT SUM(u.workingHours) FROM employee_timesheet u WHERE u.employeeName = :employeeName")
	float getWorkingByEmployeeName(@Param("employeeName") String employeeName);

	//Optional<EmployeeTimesheet> findByEmployeeNameAndEmployeeId(String employeeName, String employeeId);

	//find employee timesheet using employee name
	List<EmployeeTimesheet> findByEmployeeName(String employeeName);

}


