package com.h2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2db.dao.TestDao;
//import com.h2db.repository.Test;


@RestController
public class TestController {
	
	
	@Autowired
	TestDao testdao;
	
	@RequestMapping("/ids")
	public List getIds(){
		
		List lst = testdao.getAllUsers();
		
		return lst;
	}
	
	@RequestMapping("/hello")
	public String sayHello(){
		
		String hello= "Helllo";
		
		return hello;
	}

}
