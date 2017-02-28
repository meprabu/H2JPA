package com.h2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2db.dao.TestDao;
import com.h2db.model.Test;


@RestController
public class TestController {
	
	
	@Autowired
	TestDao testdao;
	
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

}
