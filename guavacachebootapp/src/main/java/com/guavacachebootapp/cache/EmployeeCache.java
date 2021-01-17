package com.guavacachebootapp.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.guavacachebootapp.entities.Employee;
import com.guavacachebootapp.service.IEmployeeService;

public class EmployeeCache {

	//Loading Cache to maintain the cache for employee against the employee id
	private LoadingCache<Integer, Employee> employeeCache;
	
	public EmployeeCache(int expirationDuration, IEmployeeService employeeService) {
		// TODO Auto-generated constructor stub
		CacheLoader<Integer, Employee> loader = new CacheLoader<>() {

			@Override
			public Employee load(Integer key) throws Exception {
				// TODO Auto-generated method stub
				return employeeService.findById(key);
			}
            
        };
        
        employeeCache = CacheBuilder.newBuilder()
                .expireAfterWrite(expirationDuration, TimeUnit.SECONDS)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build(loader);
	}
	
	public Employee get(int id) throws ExecutionException {
		return employeeCache.get(id);
	}

}
