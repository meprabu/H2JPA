package com.h2db.dao;

import java.util.List;

import com.h2db.model.Test;

public interface TestDao {
	
	void create(Test test);
	List<Test> getTests();
	
}
