package com.springboot.employee.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.springboot.employee.employee.entities.Employee;
import com.springboot.employee.employee.repository.EmployeeRepository;



@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository  emp_repos;
	
	public Page<Employee> listAllEmployees(int pageNum) {
	    int pageSize = 10;
	     
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
	     
	    return emp_repos.findAll(pageable);
	}
	
	public Employee save(Employee emp) {
		return emp_repos.save(emp);
	}
	
	public Employee getEmployee(int id) {
		Optional<Employee> optEmp = emp_repos.findById(id);
		
		if(optEmp.isPresent()) {
			return optEmp.get();
		}
		
		return null;
	}
	 public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize)
	    {
	        Pageable paging = PageRequest.of(pageNo, pageSize);
	 
	        Page<Employee> pagedResult = emp_repos.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	         return null;
	        }
	    }
	 
	
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> optEmp = emp_repos.findByName(name);
		
	if(optEmp.size()>0) {
		return optEmp;
	}
		
		return null;
	}
	public List<Employee> getEmployeeByEmpManager(String empmanager) {
		List<Employee> Emp = emp_repos.findByEmpManager(empmanager);
		
	
		if(Emp.size()>0) {
			return Emp;
		}
		return null;
	}
	
	public List<Employee> getEmployees(){
		List<Employee> emp=emp_repos.findAll();
		emp.forEach(System.out::println);
		return emp_repos.findAll();
	}
	
	public Employee remove(int id) {
		Optional<Employee> optEmp = emp_repos.findById(id);
		
		if(optEmp.isPresent()) {
			Employee e = optEmp.get();
			emp_repos.delete(e);
			return e;
		}
		
		return null;
	}
	
	public Employee update(int id, Employee emp) {
		
		return emp_repos.findById(id).map(
				
				employee-> {employee.setDesignation(emp.getDesignation());
				employee.setEmpmanager(emp.getEmpmanager());
				employee.setName(emp.getName());
				
				employee.setJoin_date(emp.getJoin_date());
				employee.setSalary(emp.getSalary());
				emp_repos.save(employee);
				return employee;
				}
				
				).orElse(null);
				
				
		
		
		
	}

	
   public Slice<Employee> getAllEmployeeByManager(String empmanager,Pageable page)
   {
	   return emp_repos.findByEmpManager(empmanager, page);
   }
}
