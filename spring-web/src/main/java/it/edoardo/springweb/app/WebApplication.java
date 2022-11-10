package it.edoardo.springweb.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.edoardo.springweb.database.Database;

@EnableWebMvc @Configuration @ComponentScan("it.edoardo.springweb.controller")
public class WebApplication {
	
	@Bean(name = "database") @Scope("singleton")
	@Description("Bean used to simulate a database")
	public Database getDatabase() {
		return new Database();
	}
	
}
