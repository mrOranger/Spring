package it.edoardo.spring.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.edoardo.spring.boot.model.Indirizzo;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Integer>{
	
	public abstract List<Indirizzo> findAllByViaAndNumero(String via, int numeroCivico);
	public abstract List<Indirizzo> findAllByCittà(String città);
	public abstract List<Indirizzo> findAllByProvincia(String provincia);
	public abstract List<Indirizzo> findAllByRegione(String regione);
	public abstract List<Indirizzo> findAllByNazione(String nazione);
	
	@Query(value = "SELECT I.* FROM impiegati I JOIN indirizzi Ind WHERE I.id_impiegato = ?1",
			nativeQuery =  true)
	public abstract Optional<Indirizzo> findByImpiegato(int id);
	
	@Query(value = "SELECT Ind.* FROM indirizzi Ind JOIN impiegati I WHERE I.id_dipartimento = ?1",
			nativeQuery = true)
	public abstract List<Indirizzo> findAllByDipartimento(int id);
	
	@Query(value = "SELECT Ind.* FROM indirizzi Ind JOIN impiegati I JOIN dipartimenti D"
			+ " WHERE D.direttore = i.id_impiegato", nativeQuery = true)
	public abstract List<Indirizzo> findAllByDirigenti();
	
	@Query(value = "SELECT Ind.* FROM indirizzi Ind JOIN impiegati I JOIN dipartimenti D"
			+ " WHERE D.direttore = i.id_impiegato AND D.id_dipartimenti = ?1", nativeQuery = true)
	public abstract Optional<Indirizzo> findByDirigente(int id);
}
