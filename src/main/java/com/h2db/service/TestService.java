package com.h2db.service;

import java.util.List;

import com.h2db.model.Test;

public interface TestService {
	void create(Test test);
	List<Test> getTests();
}
