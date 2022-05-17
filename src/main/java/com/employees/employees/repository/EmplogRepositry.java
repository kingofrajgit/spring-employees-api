package com.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employees.employees.model.Emplogin;

@Repository
public interface EmplogRepositry extends JpaRepository<Emplogin, Integer> {

	@Query("select e from com.employees.employees.model.Emplogin e where e.empEmail=:userEmail")
	Emplogin findByempEmail(@Param("userEmail") String userEmail);

	@Transactional
	@Modifying
	@Query("update com.employees.employees.model.Emplogin e set  e.empPassword=:password where e.empId=:id")
	void updatepassword(@Param("id") Integer id, @Param("password") String password);

}
