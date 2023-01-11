package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp= service.getAllEmployee();
		m.addAttribute("emp",emp);
		return "index";
	}
	

	
	
	@GetMapping("/addEmployee")
	public String addemployeeForm()
	{
		return "addEmployee";
	}
	
	@RequestMapping(path= "/register" , method = RequestMethod.POST)
	public String registerEmployee(@ModelAttribute Employee employee)
	{
		service.addEmployee(employee);			
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id, Model m)
	{
		Employee employee= service.getEmployeeById(id);
		m.addAttribute("employee", employee);
		return "editEmployee";
	}
	
	@RequestMapping(path= "/update" , method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee employee)
	{
		service.addEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session)
	{
		service.deleteEmployee(id); 
		session.setAttribute("msg", "Employee Deleted Successfully!");
		return "redirect:/";
	}
	

}
