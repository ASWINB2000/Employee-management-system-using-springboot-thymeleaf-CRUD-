package com.Sbcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sbcrud.model.Employee;
@Repository
public interface repo extends JpaRepository<Employee, Long>{
	

}
