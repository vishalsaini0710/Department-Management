package com.cetpa.repositories.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.entities.Department;
import com.cetpa.repositories.DepartmentRepository;
import com.cetpa.session.ProjectSession;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public DepartmentRepositoryImpl(ProjectSession projectSession)
	{
		session=projectSession.getSession();
		transaction=session.getTransaction();
	}
	public List<Department> getDepartmentList() 
	{
		Query<Department> query=session.createQuery("from Department");
		return query.list();
	}
	public void addDepartment(Department department) 
	{
		transaction.begin();
		session.save(department);
		transaction.commit();
	}
	public Department getDepartment(int did) 
	{
		return session.get(Department.class,did);
	}
	public void updateNoOfEmployees(Department department, int n) 
	{
		transaction.begin();
		department.setNoOfEmployees(department.getNoOfEmployees()+n);
		transaction.commit();
	}
	public void deleteDepartment(Department department) 
	{
		transaction.begin();
		session.delete(department);
		transaction.commit();
	}
}
