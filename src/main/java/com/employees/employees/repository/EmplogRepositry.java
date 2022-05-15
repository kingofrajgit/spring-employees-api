package com.employees.employees.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employees.employees.model.Emplogin;



@Repository
public interface EmplogRepositry extends JpaRepository<Emplogin,Integer>{
	
	@Query("select e from Emplogin e where e.empEmail=:userEmail")
	Emplogin findByempEmail(@Param("userEmail") String userEmail);
   
}
