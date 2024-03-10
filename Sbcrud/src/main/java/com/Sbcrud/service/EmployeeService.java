package com.Sbcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Sbcrud.model.Employee;
@Service
public interface EmployeeService {
	List<Employee> getallEmployees();
	void saveEmployee(Employee emp);
	Employee getEmployeeById(long id);
	void deleteEmployeebyId(long id);

}
