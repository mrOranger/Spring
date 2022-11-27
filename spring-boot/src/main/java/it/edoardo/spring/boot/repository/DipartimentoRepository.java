package it.edoardo.spring.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.edoardo.spring.boot.model.Dipartimento;

public interface DipartimentoRepository extends JpaRepository<Dipartimento, Integer>{
	
	public abstract Optional<Dipartimento> findByNome(String nome);
	
	@Query(value = "SELECT D.* FROM dipartimenti D, impiegati I WHERE I.lavora_in = D.id AND I.id = ?1"
			,nativeQuery =  true)
	public abstract Optional<Dipartimento> findByImpiegato(int id);
	
	@Query(value = "SELECT D.* FROM dipartimenti D, impiegati I WHERE I.dirige = ?1"
			,nativeQuery =  true)
	public abstract Optional<Dipartimento> findByDirettore(int id);

}
