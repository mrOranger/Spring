package it.edoardo.spring.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.spring.boot.dao.impl.ImpiegatoService;

@RestController 
public class ImpiegatiController {
	
	@Autowired private ImpiegatoService service;

}
