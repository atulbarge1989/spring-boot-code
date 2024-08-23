package com.mobis.demo.service;

import java.util.List;

import com.mobis.demo.entity.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee emp);
	
	Employee getEmployeeById(Long empId);
	
	List<Employee> getAllEmployees();
	
	Employee updateEmployee(Employee employee);
	
	Employee deleteEmployee(Long empId);

}
