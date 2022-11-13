package it.edoardo.springweb.app;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.common.collect.Lists;

import it.edoardo.springweb.database.Database;
import it.edoardo.springweb.model.Item;
import it.edoardo.springweb.model.Order;
import it.edoardo.springweb.model.Product;
import it.edoardo.springweb.model.User;

@EnableWebMvc @Configuration @ComponentScan("it.edoardo.springweb.controller")
public class WebApplication {
	
	@Bean(name = "database") @Scope("singleton")
	@Description("Bean used to simulate a database")
	public Database getDatabase() {
		return new Database();
	}
	
	@Bean(name = "users") @Scope("singleton")
	@Description("Bean containing the list of users in this application to inject in Database Bean")
	public List<Item> getUsers() {
		return Lists.newArrayList(new User("Mario", "Rossi"), 
				new User("Maria", "Neri"),
				new User("Federico", "Verdi"),
				new User("Federica", "Bruni"));
	}
	
	@Bean(name = "products") @Scope("singleton")
	@Description("Bean containing the list of products in this application to inject in Database Bean")
	public List<Item> getProducts() {
		return Lists.newArrayList(new Product("Ammoniaca"),
				new Product("Pane"),
				new Product("Candeggina"),
				new Product("Acqua"),
				new Product("Zucchine"),
				new Product("Pasta"));
	}
	
	@Bean(name = "orders") @Scope("singleton")
	@Description("Bean containing the list of orders in this application to inject in Database Bean")
	public List<Item> getOrders() {
		return Lists.newArrayList(new Order(getProducts().subList(2, 5), getUsers().get(0)),
				new Order(getProducts().subList(1, 3), getUsers().get(1)),
				new Order(getProducts().subList(3, 5), getUsers().get(2)),
				new Order(getProducts().subList(0, 5), getUsers().get(3)));
	}
}
