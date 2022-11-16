package it.edoardo.springweb.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.edoardo.springweb.database.Database;
import it.edoardo.springweb.logger.Logger;

@EnableWebMvc @Configuration @ComponentScan("it.edoardo.springweb.controller")
@PropertySource(value = "classpath:values.properties")
@EnableAspectJAutoProxy
public class WebApplication {
	
	@Value("${database.driver}") private String driver;
	@Value("${database.user}") private String user;
	@Value("${database.password}") private String password;
	@Value("${database.url}") private String url;
	@Value("${database.port}") private String port;
	
	
	@Bean(name = "database") @Scope("singleton")
	@Description("Bean used to simulate a database")
	public Database getDatabase() {
		return new Database(driver, user, password, url, port);
	}
	
	@Bean(name = "logger") @Scope("singleton")
	@Description("Bean of a logger for the User Controller")
	public Logger getUserLogger() {
		return new Logger();
	}
}
