package com.h2db.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2db.dao.TestDao;
import com.h2db.model.Departments;
import com.h2db.model.Test;
import com.h2db.service.DepartmentsService;


@RestController
public class TestController {
	
	
	@Autowired
	TestDao testdao;
	
	@Autowired
	DepartmentsService departmentsService;
	
	@RequestMapping("/ids")
	public List<Test> getIds(){
		
		List<Test> lst = testdao.getTests();
		
		return lst;
	}
	
	@RequestMapping("/hello")
	public String sayHello(){
		
		String hello= "Helllo";
		Test test = new Test(1,"test");
		testdao.create(test);
		return hello;
	}
	
	
	@RequestMapping("/getDepartments")
	public List<Departments> getDepartments(){
		List<Departments>  departments = new ArrayList<Departments>();
		for(Departments department:departmentsService.getDepartments()){
			Departments depart = new Departments();
			depart.setDeptNo(department.getDeptNo());
			depart.setDeptName(department.getDeptName());
			departments.add(depart);
		}
		
		return departments;
	}

}
