package com.employees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employees.employees.model.Sellers;

@Repository
public interface SellersRepository extends JpaRepository<Sellers, Integer>{

}
