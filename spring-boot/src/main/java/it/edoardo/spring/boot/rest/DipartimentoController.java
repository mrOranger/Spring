package it.edoardo.spring.boot.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edoardo.spring.boot.dao.impl.DipartimentoService;
import it.edoardo.spring.boot.model.Dipartimento;

@RestController @RequestMapping(path = "/dipartimenti")
public class DipartimentoController {
	
	@Autowired private DipartimentoService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Dipartimento>> getDipartimenti() {
		final List<Dipartimento> found = this.service.getAllDipartimenti();
		if(found.size() == 0) {
			return new ResponseEntity<List<Dipartimento>>(found, HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<List<Dipartimento>>(found, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}/")
	public ResponseEntity<Dipartimento> getDipartimento(@PathVariable int id) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoById(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/nome/{nome}/")
	public ResponseEntity<Dipartimento> getDipartimentoByNome(@PathVariable String nome) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoByNome(nome), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);		
	}
	
	@GetMapping(path = "/impiegato/{id}/")
	public ResponseEntity<Dipartimento> getDipartimentoByImpiegato(@PathVariable int id) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoByImpiegato(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);		
	}
	
	@GetMapping(path = "/dirigente/{id}/")
	public ResponseEntity<Dipartimento> getDipartimentoByDirigente(@PathVariable int id) {
		try {
			return new ResponseEntity<Dipartimento>(this.service.getDipartimentoByDirigente(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.NO_CONTENT);		
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Dipartimento> postDipartimento(@RequestBody Dipartimento dipartimento) {
		return new ResponseEntity<Dipartimento>(this.service.postDipartimento(dipartimento), HttpStatus.OK);
	}
	
	@PutMapping(path = "/")
	public ResponseEntity<List<Dipartimento>> putDipartimenti(@RequestBody Iterable<Dipartimento> dipartimenti) {
		return new ResponseEntity<List<Dipartimento>>(this.service.putDipartimenti(dipartimenti), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}/")
	public ResponseEntity<Dipartimento> putDipartimento(@PathVariable int id, @RequestBody Dipartimento dipartimento) {
		return new ResponseEntity<Dipartimento>(this.service.putDipartimento(id, dipartimento), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/")
	public void deleteDipartimenti() {
		this.service.deleteDipartimenti();
	}
	
	@DeleteMapping(path = "/{id}/")
	public ResponseEntity<Dipartimento> deleteDipartimento(@PathVariable int id) {
		try {
			this.service.deleteDipartimento(id);
			return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.OK);
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Dipartimento>((Dipartimento)null, HttpStatus.BAD_REQUEST);
	}

}
