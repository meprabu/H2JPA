package com.h2db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2db.dao.DepartmentsDao;
import com.h2db.model.Departments;
import com.h2db.service.DepartmentsService;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{
	
	@Autowired
	DepartmentsDao departmentsDao;

	@Override
	public List<Departments> getDepartments() {
		
		return departmentsDao.getDepartaments();
		
	}
	
	

}
