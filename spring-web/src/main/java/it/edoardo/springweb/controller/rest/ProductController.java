package it.edoardo.springweb.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "products/")
public class ProductController {
	
	@RequestMapping(path = "/")
	public String test() {
		return "Product Controller";
	}

}
