package com.springboot.employee.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.employee.employee.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>  {

	
	List<Employee> findByName(String name);

	
	List<Employee> findByEmpManager(String empmanager);
	
	
	Slice<Employee> findByName(String name,Pageable page);
	Slice<Employee> findByEmpManager(String empmanager,Pageable page);
	
	
}