package com.mobis.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;

import com.mobis.demo.entity.Employee;
import com.mobis.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins="*")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping()
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		Employee savedEmp = empService.createEmployee(employee);	
		return new ResponseEntity<>(savedEmp,HttpStatus.CREATED);

}
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmplpyeeById(@PathVariable("id") long id){
		Employee employee = empService.getEmployeeById(id);                       
		return new ResponseEntity<>(employee,HttpStatus.OK);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = empService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
		}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long empId, @RequestBody Employee employee){
		employee.setId(empId);
		Employee updateEmp = empService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmp, HttpStatus.OK);	
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long empId){
		empService.deleteEmployee(empId);
		return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
		
		
	}

}