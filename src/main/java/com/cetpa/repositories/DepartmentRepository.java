package com.cetpa.repositories;

import java.util.List;

import com.cetpa.entities.Department;

public interface DepartmentRepository
{
	List<Department> getDepartmentList();
	void addDepartment(Department department);
	Department getDepartment(int did);
	void updateNoOfEmployees(Department department, int n);
	void deleteDepartment(Department department);
}
