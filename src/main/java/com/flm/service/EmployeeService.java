package com.flm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.dao.EmployeeDAO;
import com.flm.model.Employee;

@Component
public class EmployeeService {
        
	@Autowired
	EmployeeDAO employeeDAO;
	public String saveEmployee(Employee employee) {
		
		return employeeDAO.saveEmployee(employee);                 
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}
	
	public void deleteEmployee(int id) {
		
		Employee emp=new Employee(id," ",0," "," ",0);
		  employeeDAO.deleteEmployee(emp);
	}
	
	public Employee findEmployeeById(int id) {
		return 	employeeDAO.findEmployeeById(id);
	}
	
	public void updateEmployee(Employee emp) {
		
		employeeDAO.updateEmployee(emp);
	}
}
