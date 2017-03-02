package com.h2db.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.h2db.dao.DepartmentsDao;
import com.h2db.model.Departments;


@Repository
public class DepartmentsDaoImpl implements DepartmentsDao{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Departments> getDepartaments() {
		Query query = entityManager.createQuery("SELECT d FROM Departments d");
		List<Departments> departments = query.getResultList();
		
		return departments;
	}

	
	

}
