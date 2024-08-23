package com.mobis.demo.service.impl;

import java.util.List;

import org.apache.el.stream.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobis.demo.controller.EmployeeController;
import com.mobis.demo.entity.Employee;
import com.mobis.demo.exception.ResourceNotFoundException;
import com.mobis.demo.repository.EmployeeRepository;
import com.mobis.demo.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;



@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepository;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Override
	public Employee createEmployee(Employee emp) {
		logger.info("Employee saved successfully");
		return empRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		java.util.Optional<Employee> empid = this.empRepository.findById(empId);
		
		if(empid.isPresent()) {
			
			logger.info("Employee id" + empid.get());
			return empid.get();
			
			
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + empid);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
		}


	@Override
	public Employee deleteEmployee(Long empId) {
		java.util.Optional<Employee> empid = empRepository.findById(empId);
		
		if(empid.isPresent()) {
		empRepository.deleteById(empId);
		
		logger.info("Employee deleted.." + empId);
		return empid.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id  : " + empid);
		}
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		
		java.util.Optional<Employee> emp = empRepository.findById(employee.getId());
		logger.info("Employee id.." + employee.getEmailId());
		
		if(emp.isPresent()) {
			Employee empUpdate = emp.get();
			
			empUpdate.setId(employee.getId());
			empUpdate.setFirstName(employee.getFirstName());
			empUpdate.setLastName(employee.getLastName());
			empUpdate.setEmailId((employee.getEmailId()));
		    empRepository.save(empUpdate);
		    logger.info("Employee updated successfully" + employee.getEmailId());
		    return empUpdate;
	}
		else {
            throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
        }
	}
}
