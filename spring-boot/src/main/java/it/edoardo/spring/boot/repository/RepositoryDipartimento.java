package it.edoardo.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.edoardo.spring.boot.model.Dipartimento;

public interface RepositoryDipartimento extends JpaRepository<Dipartimento, Integer>{

}
