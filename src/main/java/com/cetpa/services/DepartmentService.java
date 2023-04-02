package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Department;

public interface DepartmentService 
{
	List<Department> getList();
	void saveRecord(Department department);
	void deleteRecord(int did);
}
