package com.guavacachebootapp.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guavacachebootapp.cache.EmployeeCache;
import com.guavacachebootapp.entities.Employee;
import com.guavacachebootapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeCache employeeCache;
	
	@GetMapping
	public List<Employee> getEmployee(){
		return employeeService.findAll();
		//return Arrays.asList(new Employee(1, "Jack", "S", 27000), new Employee(2, "Mike", "P", 72000));
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) throws ExecutionException {
		long startTimeStamp = System.currentTimeMillis();
		Employee employee = employeeCache.get(id);
		long endTimeStamp = System.currentTimeMillis();
		employee.setTotalFetchTime(endTimeStamp - startTimeStamp);
		return employee;
	}
	
}
