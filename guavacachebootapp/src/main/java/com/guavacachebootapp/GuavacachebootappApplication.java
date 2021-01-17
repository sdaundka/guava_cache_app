package com.guavacachebootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.guavacachebootapp.cache.EmployeeCache;
import com.guavacachebootapp.service.IEmployeeService;

@SpringBootApplication
public class GuavacachebootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuavacachebootappApplication.class, args);
	}
	
	@Bean
	public EmployeeCache employeeCache(IEmployeeService employeeService) {
		return new EmployeeCache(60, employeeService);
	}

}
