package it.edoardo.spring.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;

import it.edoardo.spring.boot.dao.impl.DipartimentoService;

public class DipartimentoController {
	
	@Autowired private DipartimentoService service;

}
