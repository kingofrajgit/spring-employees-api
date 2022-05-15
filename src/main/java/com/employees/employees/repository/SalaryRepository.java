package com.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employees.employees.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer> {

	@Transactional
	@Modifying
	@Query("update Salary s set s.salary=:salary,s.salaryStatus=:status where s.empId=:empId" )
	void update(@Param("empId")Integer empId,@Param("salary") Integer salary,@Param("status") String status);

}
