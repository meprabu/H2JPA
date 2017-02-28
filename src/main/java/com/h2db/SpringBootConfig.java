package com.h2db;

import org.h2.server.web.WebServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Profile("bootConfig")
@Configuration
@EnableTransactionManagement
public class SpringBootConfig {
	
	
}
