package com.springboot.employee.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.employee.entities.Employee;
import com.springboot.employee.employee.exceptions.EmployeeNotFoundException;
import com.springboot.employee.employee.repository.EmployeeRepository;
import com.springboot.employee.employee.service.EmployeeService;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {

	
	@Autowired
	EmployeeService emp_service;
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return emp_service.getEmployees();
	}
	
	
	@GetMapping("/page/{pageNum}")
	public  List<Employee> viewPage(
	        @PathVariable(name = "pageNum") int pageNum) {
	     
	    Page<Employee> page = emp_service.listAllEmployees(pageNum);
	     
	    List<Employee> listEmployees = page.getContent();
	     
	   
	     
	    return listEmployees;
	}
	
	@GetMapping("/page")
	public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize
          ) 
{
		
		
List<Employee> list = emp_service.getAllEmployees(pageNo-1, pageSize);



return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK); 


}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable("empId") int id){
		Employee employee = emp_service.getEmployee(id);
		 
		 if(employee==null) {
			 
			 throw new EmployeeNotFoundException("id" + id);
			 
		 }
		 return employee;
	}
	
	@GetMapping("/employees/employeename/{empname}")
	public List<Employee> getEmployeeByName(@PathVariable("empname") String name){
		
		
		
		 List<Employee> employeeByName = emp_service.getEmployeeByName(name);
		 
		 if(employeeByName.size()==0) {
			 throw new EmployeeNotFoundException("employee details not found ");
		 }
		 
		 return employeeByName;
		 
	}
	@GetMapping("/employees/employeemanager/{empmanager}")
	public List<Employee> getEmployeeByManager(@PathVariable("empmanager") String emp_manager){
		 List<Employee> employeeByEmpManager = emp_service.getEmployeeByEmpManager(emp_manager);
		 if(employeeByEmpManager.size()==0) {
			 throw new EmployeeNotFoundException("employee manager  not found  ");
		 }
	
	return employeeByEmpManager;
	
	}
	
	@GetMapping("/page/employee_manager/{empmanager}")
	public ResponseEntity<List<Employee>> getAllEmployees(
          @PathVariable("empmanager") String empmanager,@RequestParam Integer pagenumber
             ) 
	{
	     
	     
	     List<Employee> list=emp_service.getEmployeeByEmpManager(empmanager);
	     Slice<Employee> slice = null;
         List<Employee> employeeList;
	     Pageable pageable = PageRequest.of(pagenumber-1, 2);
	     while (true) {
	         slice = emp_service.getAllEmployeeByManager(empmanager,pageable);
	         int number = slice.getNumber();
	         int numberOfElements = slice.getNumberOfElements();
	         int size = slice.getSize();
	         System.out.printf("slice info - page number %s, numberOfElements: %s, size: %s%n",
	                 number, numberOfElements, size);
	         employeeList = slice.getContent();
	         employeeList.forEach(System.out::println);
	         if(!slice.previousPageable().hasPrevious()) {
	         	
	         }
	             if (!slice.hasNext()) {
	                 break;
	             }
	             pageable = slice.nextPageable();
	             pageable=slice.previousPageable();
	             return new ResponseEntity<List<Employee>>(employeeList, new HttpHeaders(), HttpStatus.OK);
	         }
	  return null;
	 
	}


	@PostMapping("/employees")
	@ResponseStatus(code = HttpStatus.OK)
	public Employee saveEmp(@RequestBody Employee emp) throws Exception {
	
	if(emp.getName()!=null)
				return emp_service.save(emp);
		
		throw new Exception("emp name is not valid");
	}   
	
	

	

	
	@PutMapping("/employees/{empId}")
	public Employee update(@PathVariable("empId") int id, @RequestBody Employee emp) {
		return emp_service.update(id, emp);
	}
	
	@DeleteMapping("/delemployees/{empId}")
	public Employee deleteEmp(@PathVariable("empId")int id) {
		return emp_service.remove(id);
	}
	
	
	
	
}