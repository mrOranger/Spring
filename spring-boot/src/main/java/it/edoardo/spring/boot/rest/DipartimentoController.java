package it.edoardo.spring.boot.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.edoardo.spring.boot.dao.impl.DipartimentoService;
import it.edoardo.spring.boot.model.Dipartimento;

public class DipartimentoController {
	
	@Autowired private DipartimentoService service;
	
	public ResponseEntity<List<Dipartimento>> getDipartimenti() {
		final List<Dipartimento> found = this.service.getAllDipartimenti();
		if(found.size() == 0) {
			return new ResponseEntity<List<Dipartimento>>(found, HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<List<Dipartimento>>(found, HttpStatus.OK);
	}
	
	public ResponseEntity<Dipartimento> getDipartimento(int id) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoByDirigente(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Dipartimento> getDipartimentoByNome(String nome) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoByNome(nome), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);		
	}
	
	public ResponseEntity<Dipartimento> getDipartimentoByImpiegato(int id) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoByImpiegato(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);		
	}
	
	public ResponseEntity<Dipartimento> getDipartimentoByDirigente(int id) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoByDirigente(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);		
	}
	
	public ResponseEntity<Dipartimento> postDipartimento(Dipartimento dipartimento) {
		return new ResponseEntity<Dipartimento>(this.service.postDipartimento(dipartimento), HttpStatus.OK);
	}
	
	public ResponseEntity<List<Dipartimento>> putDipartimenti(Iterable<Dipartimento> dipartimenti) {
		return new ResponseEntity<List<Dipartimento>>(this.service.putDipartimenti(dipartimenti), HttpStatus.OK);
	}
	
	public ResponseEntity<Dipartimento> putDipartimento(int id, Dipartimento dipartimento) {
		return new ResponseEntity<Dipartimento>(this.service.putDipartimento(id, dipartimento), HttpStatus.OK);
	}
	
	public void deleteDipartimenti() {
		this.service.deleteDipartimenti();
	}
	
	public ResponseEntity<Dipartimento> deleteDipartimento(int id) {
		try {
			this.service.deleteDipartimento(id);
			return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.OK);
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.BAD_REQUEST);
	}

}
