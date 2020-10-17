package com.web.adrielgrapes.employeeTracker.controller;

import com.web.adrielgrapes.employeeTracker.EmployeeRepository;
import com.web.adrielgrapes.employeeTracker.bean.Employee;
import com.web.adrielgrapes.employeeTracker.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping//("/Example")
public class EmployeeController
{
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/start")
	public String newEmployee()
	{
		return "createEmployee";
	}
	
	@GetMapping("/addEmployee")
    public String sendForm(Model model) 
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String processForm(@ModelAttribute Employee employee, Model model) 
    {
    	model.addAttribute("employee", employee);
    	employeeRepository.save(employee);
        return "showMessage";
    }
    
    @GetMapping("/lookUp")
    public String sendLookUp(Model model, String lastName, Employee employee)
    {	
    	model.addAttribute("employee", employeeRepository.findByLastName(lastName));
    	return "lookUp";
    }
    
    @GetMapping("/allEmp")
    public String getAll(Model model)
    {
    	model.addAttribute("employee", employeeRepository.findAll());
    	return "allEmp";
    }
}

