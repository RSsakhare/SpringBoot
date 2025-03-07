package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.*;
import com.dao.*;

@Controller
public class EmpController 
{
	@Autowired
	EmpRepository erepo;
	
	@RequestMapping("index")
	public String getIndexPage()
	{
		return "index";
	}
	
	@RequestMapping("addEmpForm")
	public String getAddEmpFormPage()
	{
		return "addEmpForm";
	}
	
	@RequestMapping("emp")
	public String getAddEmp(Employee e)
	{
		erepo.save(e);
		return "index";
	}
	
	@RequestMapping("showEmpByIdForm")
	public String getShowEmpByIdFormPage()
	{
		return "showEmpByIdForm";
	}
	
	@RequestMapping("empSearchById")
	@ResponseBody
	public Employee getEmpById(@RequestParam("eid") int eid) 
	{
		return erepo.findById(eid).orElse(null);
		
	}
	
	@RequestMapping("showAllEmp")
	@ResponseBody
	public ArrayList<Employee> getShowAllEmp()
	{
		ArrayList<Employee> elist = (ArrayList<Employee>) erepo.findAll();
		return elist;
	}
	
	//showEmpByNameForm
	@RequestMapping("showEmpByNameForm")
	public String getShowEmpByNameFormPage()
	{
		return "showEmpByNameForm";
	}
	
	@RequestMapping("empSearchByName")
	@ResponseBody
	public ArrayList<Employee> getEmpByName(@RequestParam("ename") String ename )
	{

		return (ArrayList<Employee>) erepo.findByEname(ename);
	}
	
	@RequestMapping("EmpBySalRange")
	public String getEmpBySalRange()
	{
		return "EmpBySalRange";
	}
	
	@RequestMapping("SalRange")
	@ResponseBody
	public ArrayList<Employee> getSalRange( int minSal, int maxSal)//@RequestParam("") is only for String
	{
		return erepo.findByEsalBetween(minSal, maxSal);
	}
}
