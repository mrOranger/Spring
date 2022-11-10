package it.edoardo.springweb.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping(path = "users/")
public class UserController {
	
	@RequestMapping(path = "/")
	public String test() {
		return "User Controller";
	}

}
