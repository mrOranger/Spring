package it.edoardo.springdataaccess;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.edoardo.springdataaccess.dao.OrderService;
import it.edoardo.springdataaccess.dao.ProductService;
import it.edoardo.springdataaccess.dao.UserService;

@EnableWebMvc 
@Configuration @ComponentScan("it.edoardo.springdataaccess.controller.rest")
@PropertySource(value = "classpath:database.properties")
public class WebApplication {
	
	@Value("${database.driver_class_name}") private String driver;
	@Value("${database.url}") private String url;
	@Value("${database.username}") private String username;
	@Value("${database.password}") private String password;
	
	@Bean @Scope("singleton")
	@Description("DataSource used for connecting to the database")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driver);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);
		dataSource.setUrl(this.url);
		return dataSource;
	}
	
	@Bean @Scope("singleton")
	@Description("User service bean implementing the DAO pattern")
	public UserService getUserService() {
		return new UserService(getDataSource());
	}
	
	@Bean @Scope("singleton")
	@Description("Product service bean implementing the DAO pattern")
	public ProductService getProductService() {
		return new ProductService(getDataSource());
	}
	
	@Bean @Scope("singleton")
	@Description("Order service bean implementing the DAO pattern")
	public OrderService getOrderService() {
		return new OrderService(getDataSource());
	}
}
