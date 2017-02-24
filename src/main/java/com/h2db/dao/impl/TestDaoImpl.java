package com.h2db.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.h2db.dao.TestDao;
import com.h2db.model.Test;


@Repository
public class TestDaoImpl implements TestDao{
	
	 @PersistenceContext
	    private EntityManager entityManager;

	    @Override
	    public void create(Test test) {
	        entityManager.persist(test);
	    }

	    
	    @Override
	    public List<Test> getTests() {
	    	Query query = entityManager.createQuery("SELECT t FROM Test t");
	    	List<Test> lstTest = query.getResultList();
	    	return lstTest;
	    }
}
