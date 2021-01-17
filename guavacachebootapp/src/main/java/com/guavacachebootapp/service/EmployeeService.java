package com.guavacachebootapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guavacachebootapp.entities.Employee;
import com.guavacachebootapp.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(employeeOptional.isPresent())
			return employeeOptional.get();
		return null;
	}

}
