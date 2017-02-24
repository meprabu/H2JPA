package com.h2db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2db.dao.TestDao;
import com.h2db.model.Test;
import com.h2db.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	
	  @Autowired
	    private TestDao testDao;

	    @Override
	    public void create(Test test) {
	    	testDao.create(test);
	    }

		@Override
		public List<Test> getTests() {
			return testDao.getTests();
		}

}
