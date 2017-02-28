package com.h2db.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h2db.dao.TestDao;
import com.h2db.model.Test;


@Repository
public class TestDaoImpl implements TestDao{
	
		@PersistenceContext
	    private EntityManager entityManager;
		
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Transactional
	    @Override
	    public void create(Test test) {
	    	Test t = entityManager.find(Test.class, 1);
	    	if(t == null){
	    		entityManager.persist(test);
	    	}
	    }

	    
	    @Override
	    public List<Test> getTests() {
	    	
	    	
	    	Query query = entityManager.createQuery("SELECT t FROM Test t");
	    	List<Test> lstTest = query.getResultList();
	    	logger.debug("test-----------------");
	    	return lstTest;
	    }
}
