package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.entities.Department;
import com.cetpa.services.DepartmentService;

@Controller
public class DepartmentController 
{
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("department/dashboard")
	public String getDepartmentDashBoard(Model model)
	{
		List<Department> departmentList=departmentService.getList();
		model.addAttribute("dlist",departmentList);
		return "department/department-list";
	}
	@RequestMapping("department/add")
	public String getAddDepartmentView()
	{
		return "department/add-department";
	}
	@RequestMapping("department/save-record")
	public String saveDepartmentRecord(Department department)
	{
		departmentService.saveRecord(department);
		return "redirect:dashboard";
	}
	@RequestMapping("department/delete-record")
	public String deleteDepartmentRecord(int did)
	{
		departmentService.deleteRecord(did);
		return "redirect:dashboard";
	}
}
