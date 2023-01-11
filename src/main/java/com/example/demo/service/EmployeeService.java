package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo ;
	
	
	public void addEmployee(Employee employee)
	{
		repo.save(employee);
	}
	
	public List<Employee> getAllEmployee()
	{
		return repo.findAll();
	}
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> employee = repo.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		
		return null;
	}
	
	public void deleteEmployee(int id)
	{
		repo.deleteById(id);
	}

}
