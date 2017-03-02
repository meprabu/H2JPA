package com.h2db.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.h2db.dao.TestDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDaoImplTests {
	
	@Mock private EntityManager entityManager;
	@Mock private Query query;
	@Spy private List<com.h2db.model.Test> tests = getTests();
	
	private TestDao testdao;
	
	
	@Before
	public void setUp()throws Exception{
		MockitoAnnotations.initMocks(this);
		testdao = new TestDaoImpl();
		((TestDaoImpl) testdao).setEntityManager(entityManager);
	}
	
	@Test
	public void getTestsfromDB(){
		Mockito.doReturn(query).when(entityManager).createQuery("SELECT t FROM Test t");
		Mockito.doReturn(tests).when(query).getResultList();
		assertEquals(getTests().size(),testdao.getTests().size());
		
	}
	
	@Test
	public void create(){
		Mockito.doReturn(getTest()).when(entityManager).find(com.h2db.model.Test.class, 1);
		testdao.create(getTest());
	}
	
	@Test
	public void createNull(){
		Mockito.doReturn(null).when(entityManager).find(com.h2db.model.Test.class, 1);
		testdao.create(getTest());
	}

	
	private List<com.h2db.model.Test> getTests(){
		List<com.h2db.model.Test> lstTest = new ArrayList<com.h2db.model.Test>();
		com.h2db.model.Test test1 = new com.h2db.model.Test(1,"test1");
		com.h2db.model.Test test2 = new com.h2db.model.Test(2,"test2");
		lstTest.add(test1);
		lstTest.add(test2);
		return lstTest;
	}
	
	private com.h2db.model.Test getTest(){
		return new com.h2db.model.Test(1,"Test1");
	}
}
