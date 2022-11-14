package it.edoardo.springweb.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.common.collect.Lists;

import it.edoardo.springweb.database.Database;
import it.edoardo.springweb.logger.Logger;
import it.edoardo.springweb.model.Item;
import it.edoardo.springweb.model.Order;
import it.edoardo.springweb.model.Product;
import it.edoardo.springweb.model.User;

@EnableWebMvc @Configuration @ComponentScan("it.edoardo.springweb.controller")
@PropertySource(value = "classpath:values.properties")
@EnableAspectJAutoProxy
public class WebApplication {
	
	@Value(value = "${user.first_name}")
	private String[] names;
	
	@Value(value = "${user.last_name}")
	private String[] lastNames;
	
	@Value(value = "${product.name}")
	private String[] products;
	
	@Bean(name = "user") @Scope("prototype")
	@Description("Bean of a user item")
	public Item getUser() {
		return new User(names[((int)(Math.floor(Math.random()*names.length)))], lastNames[((int)(Math.floor(Math.random()*lastNames.length)))]);
	}
	
	@Bean(name = "product") @Scope("prototype")
	@Description("Bean of a product item")
	public Item getProduct() {
		return new Product(products[((int)(Math.floor(Math.random()*products.length)))]);
	}
	
	@Bean(name = "users") @Scope("singleton")
	@Description("Bean containing the list of users in this application to inject in Database Bean")
	public List<Item> getUsers() {
		return Lists.newArrayList(getUser(), getUser(), getUser(), getUser());
	}
	
	@Bean(name = "products") @Scope("singleton")
	@Description("Bean containing the list of products in this application to inject in Database Bean")
	public List<Item> getProducts() {
		return Lists.newArrayList(getProduct(), getProduct(), getProduct(), getProduct(), getProduct(), getProduct());
	}
	
	@Bean(name = "orders") @Scope("singleton")
	@Description("Bean containing the list of orders in this application to inject in Database Bean")
	public List<Item> getOrders() {
		return Lists.newArrayList(new Order(getProducts().subList(2, 5), getUsers().get(0)),
				new Order(getProducts().subList(1, 3), getUsers().get(1)),
				new Order(getProducts().subList(3, 5), getUsers().get(2)),
				new Order(getProducts().subList(0, 5), getUsers().get(3)));
	}
	
	@Bean(name = "database") @Scope("singleton")
	@Description("Bean used to simulate a database")
	public Database getDatabase() {
		return new Database(getUsers(), getProducts(), getOrders());
	}
	
	@Bean(name = "logger") @Scope("singleton")
	@Description("Bean of a logger for the User Controller")
	public Logger getUserLogger() {
		return new Logger();
	}
}
