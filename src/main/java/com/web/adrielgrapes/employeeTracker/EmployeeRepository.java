package com.web.adrielgrapes.employeeTracker;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.adrielgrapes.employeeTracker.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	Employee findByLastName(String lastName);
	Employee findByFirstName(String firstName);
	Employee findByTitle(String title);
	
}
