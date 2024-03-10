package com.Sbcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Sbcrud.model.Employee;
import com.Sbcrud.service.EmployeeService;

@Controller
public class Main {
	@Autowired
	private EmployeeService ser;
	@RequestMapping("/")//display list of employees
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees", ser.getallEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {	//create model attribute to bind the form data
		Employee emp =new Employee();
		model.addAttribute("emp", emp);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("emp") Employee employee) {
		ser.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id,Model model){
		//get employee from the service
		Employee emp=ser.getEmployeeById(id);
		
		//set employee as model attribute to prepopulate the form
		model.addAttribute("employee",emp);
		return "update_employee";
		
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeebyId(@PathVariable(value="id") long id) {
		ser.deleteEmployeebyId(id);
		return "redirect:/";
	}
}
