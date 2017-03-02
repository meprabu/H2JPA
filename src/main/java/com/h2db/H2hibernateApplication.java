package com.h2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class H2hibernateApplication extends SpringBootServletInitializer {
	
	/**
	 * This is used build as jar
	 * */
	public static void main(String[] args) {
		SpringApplication.run(H2hibernateApplication.class, args);
	}
	
	/**
	 * This is used build as war
	 * */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		//return super.configure(builder);
		return builder.sources(H2hibernateApplication.class);
	}
	
	
}
