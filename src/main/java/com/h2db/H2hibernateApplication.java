package com.h2db;

import java.util.Properties;

import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@SpringBootApplication
public class H2hibernateApplication {
	
	@Autowired
    private Environment environment;
	
	//http://www.itbh.at/jpa-tools-generate-entities-from-tables-does-not-work-with-h2-database/?lang=en
	//http://mycuteblog.com/h2-database-example-hibernate-spring-boot/

	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	 
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.prabu.repository" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
	 
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
	        return properties;        
	    }
/*	 
	 @Bean(name = "h2WebServer", initMethod="start",destroyMethod="stop")
	 public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
	   return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "7654");
	 }
	 
	 @Bean(initMethod="start", destroyMethod="stop")
	 public org.h2.tools.Server h2Server() throws SQLException {
	     return org.h2.tools.Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8888");
	 }*/

	 @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
	
/*	@Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        //registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
	 */
	 
	public static void main(String[] args) {
		SpringApplication.run(H2hibernateApplication.class, args);
	}
}
