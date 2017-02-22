package com.h2db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.h2db.repository.Test;


@Repository
public class TestDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	 	
	@Autowired
	private DataSource ds;
	
	@Transactional
	public List getAllUsers(){
		List lst  = null;
		/*Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Test.class);
		System.out.print(ds);
		List<Test> lst = criteria.list();*/
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from TEST");
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
		return lst;
	}

}
