package it.edoardo.spring.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;

import it.edoardo.spring.boot.dao.impl.IndirizzoService;

public class IndirizzoController {
	
	@Autowired private IndirizzoService service;

}
