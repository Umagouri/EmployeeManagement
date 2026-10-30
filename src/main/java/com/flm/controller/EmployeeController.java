package com.flm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flm.model.Employee;
import com.flm.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
 
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String employees(Model model) {
	List<Employee>	employees=employeeService.getAllEmployees();
	
	       // send above data to jsp using model(key,value)
	            model.addAttribute("empList",employees);
		          return "employees";
	}
	
	@GetMapping("/newemployee")
	public String addEmployee() {
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(HttpServletRequest request) {
		
		        String empName   = request.getParameter("empname");
		        String empMail  = request.getParameter("empmail");
		        int empAge   = Integer.parseInt(request.getParameter("empage"));
		        double empSalary  = Double.parseDouble(request.getParameter("empsalary"));
		        String empDepartment   = request.getParameter("empdept");
		         
		        Employee emp=new Employee( empName,empSalary,empDepartment,empMail,empAge);
		        
		        employeeService.saveEmployee(emp);
		        
		        //after successful adding emp record admin should go to emp table page
		        return "redirect:/flm/employees";
		        
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		 
		employeeService.deleteEmployee(id);
		//redirects to /employees end point
		return  "redirect:/flm/employees";
		
	}
	@GetMapping("/employees/update/{id}")
	public String updateEmployee(@PathVariable("id")int id,Model model) {
		
	//if employee doesnt exist i.e.during updation,another admin comes nd delete data ,returns null
	Employee employee	=employeeService.findEmployeeById(id);
	  if(employee==null) {
		return "redirect:/flm/employees";
	   }
	  model.addAttribute("employee",employee);
	  return "edit-employee";
}
	
	@PostMapping("/employees/update")
	public String updateEmployee(HttpServletRequest request) {
		
		        int empId  =Integer.parseInt(request.getParameter("empId"));
		  String empName   = request.getParameter("empname");
	        String empMail  = request.getParameter("empmail");
	        int empAge   = Integer.parseInt(request.getParameter("empage"));
	        double empSalary  = Double.parseDouble(request.getParameter("empsalary"));
	        String empDepartment   = request.getParameter("empdept");
	         
	  Employee emp=new Employee(empId,empName,empSalary,empDepartment,empMail,empAge);
	  
	        employeeService.updateEmployee(emp);
	        return "redirect:/flm/employees";
		
	}
}
