package it.edoardo.spring.boot.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.edoardo.spring.boot.model.Impiegato;

public interface ImpiegatoRepository extends JpaRepository<Impiegato, Integer>{
	
	public abstract Optional<Impiegato> findByCodiceFiscale(String codiceFiscale);
	public abstract List<Impiegato> findAllByDataDiNascitaBetween(LocalDate start, LocalDate end);
	
	@Query(value = "SELECT I.* FROM impiegati I, indirizzi Ind WHERE I.id_indirizzo = Ind.id_indirizzo AND Ind.numero = ?2 AND Ind.via = ?1",
			nativeQuery = true)
	public abstract List<Impiegato> findAllByViaAndNumeroCivico(String via, int civico);
	
	@Query(value = "SELECT I.* FROM impiegati I, indirizzi Ind WHERE I.id_indirizzo = Ind.id_indirizzo AND Ind.città = ?1",
			nativeQuery = true)
	public abstract List<Impiegato> findAllByCittà(String città);
	
	@Query(value = "SELECT I.* FROM impiegati I, indirizzi Ind WHERE I.id_indirizzo = Ind.id_indirizzo AND Ind.regione = ?1",
			nativeQuery = true)
	public abstract List<Impiegato> findAllByRegione(String regione);
	
	@Query(value = "SELECT I.* FROM impiegati I, indirizzi Ind WHERE I.id_indirizzo = Ind.id_indirizzo AND Ind.provincia = ?1",
			nativeQuery = true)
	public abstract List<Impiegato> findAllByProvincia(String provincia);
	
	@Query(value = "SELECT I.* FROM impiegati I, indirizzi Ind WHERE I.id_indirizzo = Ind.id_indirizzo AND Ind.nazione = ?1",
			nativeQuery = true)
	public abstract List<Impiegato> findAllByNazione(String nazione);
	
	@Query(value = "SELECT I.* FROM impiegati I, recapiti R WHERE I.id_impiegato = R.id_impiegato AND R.email = ?1",
			nativeQuery = true)
	public abstract Optional<Impiegato> findByEmail(String email);
	
	@Query(value = "SELECT I.* FROM impiegati I, recapiti R WHERE I.id_impiegato = R.id_impiegato AND R.telefono = ?1",
			nativeQuery = true)
	public abstract Optional<Impiegato> findByTelefono(String telefono);
	
	@Query(value = "SELECT I.* FROM impiegati I, dipartimenti D WHERE I.id_dipartimento = D.id_dipartimento AND D.id_dipartimento = ?1",
			nativeQuery = true)
	public abstract List<Impiegato> findAllByDipartimento(int dipartimento);
	
	@Query(value = "SELECT I.* FROM impiegati I, dipartimenti D WHERE I.id_dipartimento = D.id_dipartimento AND D.direttore = I.id_impiegato",
			nativeQuery = true)
	public abstract List<Impiegato> findAllDirigenti();
	
	@Query(value = "SELECT I.* FROM impiegati I, dipartimenti D WHERE I.id_dipartimento = D.id_dipartimento AND D.id_dipartimento = ?1 AND D.direttore = I.id_impiegato",
			nativeQuery = true)
	public abstract Optional<Impiegato> findDirigenteInDipartimento(int dipartimento);

}
