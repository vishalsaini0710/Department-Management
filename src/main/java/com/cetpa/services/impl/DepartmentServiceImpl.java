package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Department;
import com.cetpa.entities.Employee;
import com.cetpa.repositories.DepartmentRepository;
import com.cetpa.repositories.EmployeeRepository;
import com.cetpa.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Department> getList() 
	{
		return departmentRepository.getDepartmentList();
	}
	public void saveRecord(Department department) 
	{
		departmentRepository.addDepartment(department);
	}
	public void deleteRecord(int did) 
	{
		Department department=departmentRepository.getDepartment(did);
		departmentRepository.deleteDepartment(department);
		List<Employee> list=employeeRepository.getListByDid(did);
		if(!list.isEmpty())
		{
			employeeRepository.deleteEmployeeByDid(list);
		}
	}
}
