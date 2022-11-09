package it.edoardo.springweb.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/rest")
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World from REST";
	}

}
