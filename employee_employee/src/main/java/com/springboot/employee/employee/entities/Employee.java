package com.springboot.employee.employee.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
private String name;

	private int salary;
private String designation;
private Date join_date;

private String empManager;

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}


public Employee(int id, String name, int salary, String designation, Date join_date, String Empmanager) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.designation = designation;
	this.join_date = join_date;
	
	empManager = Empmanager;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public Date getJoin_date() {
	return join_date;
}
public void setJoin_date(Date join_date) {
	this.join_date = join_date;
}

public String getEmpmanager() {
	return empManager;
}

public void setEmpmanager(String Empmanager) {
	empManager = Empmanager;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation
			+ ", join_date=" + join_date  + ", EmpManager=" + empManager + "]";
}












}
