package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Employee;

public interface EmployeeService 
{
	List<Employee> getList();
	void saveRecord(Employee employee);
	Employee getEmployee(int eid);
	void updateRecord(Employee employee);
}
