package com.web.adrielgrapes.employeeTracker.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
    private String title;
    private String emailAdd;
    
    public Employee()
    {
    	
    }
    
    public Employee(String firstName, String lastName, String title, String emailAdd)
    {
    	super();
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.title = title;
    	this.emailAdd = emailAdd;
    }
    
    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getfullName() {
        return firstName + lastName;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) 
    {
        this.title = title;
    }
    
    public void setemailAdd(String email) 
    {
        this.emailAdd = email;
    }
    
    public String getemailAdd()
    {
    	return emailAdd;
    }
    
    @Override
    public String toString()
    {
    	return String.format("Customer[id=%d, firstName='%s', lastName='%s'", 
    			id, firstName, lastName);
    }
    
    public Long getId()
    {
    	return id;
    }
}
