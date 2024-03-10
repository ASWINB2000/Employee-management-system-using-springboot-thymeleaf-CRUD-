package com.Sbcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sbcrud.model.Employee;
import com.Sbcrud.repository.repo;

@Service
public class EmpolyeeServiceImpl implements EmployeeService {
	@Autowired
	private repo rep; 
	@Override
	public List<Employee> getallEmployees() {
		return rep.findAll();
	}
	@Override
	public void saveEmployee(Employee emp) {
		this.rep.save(emp);
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=rep.findById(id);
		Employee employee =null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("Employee not found for id ::"+ id);
		}
		return employee;
	}
	@Override
	public void deleteEmployeebyId(long id ) {
		rep.deleteById(id);
		
	}
	
	

}
