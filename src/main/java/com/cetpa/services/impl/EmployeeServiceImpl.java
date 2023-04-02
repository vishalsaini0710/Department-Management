package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Department;
import com.cetpa.entities.Employee;
import com.cetpa.repositories.DepartmentRepository;
import com.cetpa.repositories.EmployeeRepository;
import com.cetpa.services.EmployeeService;
import com.cetpa.util.DateFormat;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Employee> getList() 
	{
		return employeeRepository.getEmployeeList();
	}

	public void saveRecord(Employee employee) 
	{
		String dob=DateFormat.chageFormat(employee.getDob());		
		employee.setDob(dob);
		employeeRepository.saveEmployee(employee);
		Department department=departmentRepository.getDepartment(employee.getDid());
		departmentRepository.updateNoOfEmployees(department,1);
	}
	public Employee getEmployee(int eid) 
	{
		return employeeRepository.getEmployee(eid);
	}
	public void updateRecord(Employee employeen) 
	{
		Employee employeeo=employeeRepository.getEmployee(employeen.getEid());
		int dido=employeeo.getDid();
		int didn=employeen.getDid();
		employeen.setDob(DateFormat.chageFormat(employeen.getDob()));
		employeeRepository.updateEmployee(employeeo,employeen);
		if(dido!=didn)
		{
			//code to update no of employees in both department
			departmentRepository.updateNoOfEmployees(departmentRepository.getDepartment(didn),1);
			departmentRepository.updateNoOfEmployees(departmentRepository.getDepartment(dido),-1);
		}
	}
}
