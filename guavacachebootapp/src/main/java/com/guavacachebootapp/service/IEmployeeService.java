package com.guavacachebootapp.service;

import java.util.List;

import com.guavacachebootapp.entities.Employee;

public interface IEmployeeService {

	List<Employee> findAll();
	Employee findById(int id);
	
}
