package it.edoardo.spring.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;

import it.edoardo.spring.boot.dao.impl.RecapitoService;

public class RecapitoController {
	
	@Autowired private RecapitoService service;
	
}
