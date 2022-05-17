package com.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employees.employees.model.ApplyLeave;

@Repository
public interface ApplyLeaveRepository extends JpaRepository<ApplyLeave,Integer> {

@Transactional
@Modifying
@Query("UPDATE com.employees.employees.model.ApplyLeave a SET a.status='ACCEPTED' WHERE a.empId=:id")
void applicationStatusAccept(@Param("id") Integer id);

@Transactional
@Modifying
@Query("update com.employees.employees.model.ApplyLeave a set a.status=:status where a.empId=:id")
void applicationStatusReject(@Param("id") Integer id,@Param("status") String status);
}
