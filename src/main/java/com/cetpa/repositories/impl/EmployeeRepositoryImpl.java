package com.cetpa.repositories.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.entities.Employee;
import com.cetpa.repositories.EmployeeRepository;
import com.cetpa.session.ProjectSession;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRepositoryImpl(ProjectSession projectSession)
	{
		session=projectSession.getSession();
		transaction=session.getTransaction();
	}
	public List<Employee> getEmployeeList() 
	{
		Query<Employee> query=session.createQuery("from Employee");
		return query.list();
	}
	public void saveEmployee(Employee employee) 
	{
		transaction.begin();
		session.save(employee);
		transaction.commit();
	}
	public Employee getEmployee(int eid) 
	{
		return session.load(Employee.class,eid);
	}
	public void updateEmployee(Employee employeeo, Employee employeen) 
	{
		transaction.begin();
		employeeo.setFirstname(employeen.getFirstname());
		employeeo.setLastname(employeen.getLastname());
		employeeo.setPhone(employeen.getPhone());
		employeeo.setDob(employeen.getDob());
		employeeo.setDid(employeen.getDid());
		employeeo.setSalary(employeen.getSalary());
		transaction.commit();
	}
	public List<Employee> getListByDid(int did) 
	{
		Query<Employee> query=session.createQuery("from Employee where did=:arg");
		query.setParameter("arg",did);
		return query.list();
	}
	public void deleteEmployeeByDid(List<Employee> list) 
	{
		transaction.begin();
		for(Employee employee:list)
		{
			session.delete(employee);
		}
		transaction.commit();
	}
}
