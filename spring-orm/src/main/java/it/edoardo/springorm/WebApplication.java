package it.edoardo.springorm;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc 
@Configuration @ComponentScan("it.edoardo.springorm.controller.rest")
@PropertySource(value = "classpath:database.properties")
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = { "it.edoardo.springorm.repository" },
		entityManagerFactoryRef = "entityMangerFactory",
		transactionManagerRef = "transactionManager")
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
	
	@Bean(name = "entityMangerFactory") @Scope("singleton")
	@Description("Bean for configurate the JPA, Hibernate and the connection with the database")
	public LocalContainerEntityManagerFactoryBean getLocalContainer() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan("it.edoardo.springorm.model");
		return factory;
	}
	
	@Bean(name = "transactionManager") @Scope("singleton")
	@Description("Bean for the manager of the transactions for the database")
	public PlatformTransactionManager getPlatformTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getLocalContainer().getObject());
		return transactionManager;
	}
}
