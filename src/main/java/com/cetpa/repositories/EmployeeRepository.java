package com.cetpa.repositories;

import java.util.List;

import com.cetpa.entities.Employee;

public interface EmployeeRepository
{
	List<Employee> getEmployeeList();
	void saveEmployee(Employee employee);
	Employee getEmployee(int eid);
	void updateEmployee(Employee employeeo, Employee employeen);
	List<Employee> getListByDid(int did);
	void deleteEmployeeByDid(List<Employee> list);
}
