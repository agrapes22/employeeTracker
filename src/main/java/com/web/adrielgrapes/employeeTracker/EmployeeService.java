package com.web.adrielgrapes.employeeTracker;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.adrielgrapes.employeeTracker.bean.Employee;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll().forEach(employeeList::add);
		return employeeList;
	}
	
	public Employee addEmployee(Employee employee)
	{
		employee = employeeRepository.save(employee);
		return employee;
	}
	
}
