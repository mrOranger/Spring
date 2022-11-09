package it.edoardo.springweb.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc @Configuration @ComponentScan("it.edoardo.springweb.controller")
public class WebApplication {

}
