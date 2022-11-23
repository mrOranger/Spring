package it.edoardo.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.edoardo.spring.boot.model.Impiegato;

public interface ImpiegatoRepository extends JpaRepository<Impiegato, Integer>{

}
