package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.entities.Department;
import com.cetpa.entities.Employee;
import com.cetpa.services.DepartmentService;
import com.cetpa.services.EmployeeService;
import com.cetpa.util.DateFormat;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	
	@RequestMapping("employee/dashboard")
	public String getEmployeeDashBoard(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "employee/employee-list";
	}
	@RequestMapping("employee/add")
	public String getAddEmployeeView(Model model)
	{
		List<Department> departmentList=departmentService.getList();
		model.addAttribute("dlist",departmentList);
		return "employee/add-employee";
	}
	@RequestMapping("employee/save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "redirect:dashboard";
	}
	@RequestMapping("employee/edit-record")
	public String getEditEmployeeView(int eid,Model model)
	{
		Employee employee=employeeService.getEmployee(eid);
		String dob=DateFormat.chageFormat(employee.getDob());
		model.addAttribute("emp",employee);
		model.addAttribute("dob",dob);
		List<Department> departmentList=departmentService.getList();
		model.addAttribute("dlist",departmentList);
		return "employee/edit-employee";
	}
	@RequestMapping("employee/update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateRecord(employee);
		return "redirect:dashboard";
	}
}
