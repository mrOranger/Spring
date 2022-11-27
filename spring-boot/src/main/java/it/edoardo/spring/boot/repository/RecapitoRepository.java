package it.edoardo.spring.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.edoardo.spring.boot.model.Recapito;

public interface RecapitoRepository extends JpaRepository<Recapito, Integer>{
	
	public abstract Optional<Recapito> findByEmail(String email);
	public abstract Optional<Recapito> findByTelefono(String telefono);
	public abstract List<Recapito> findAllByEmailContaining(String provider);
	
	@Query(value = "SELECT R.* FROM recapiti R, impiegati I "
			+ "WHERE I.id = ?1 AND R.id_impiegato = I.id", nativeQuery = true)	
	public abstract List<Recapito> findAllByImpiegato(int id);
	
	@Query(value = "SELECT R.* FROM recapiti R, impiegati I "
			+ "WHERE I.lavora_in = ?1 AND R.id_impiegato = I.id", nativeQuery = true)
	public abstract List<Recapito> findAllByDipartimento(int id);

	@Query(value = "SELECT R.* FROM recapiti R, impiegati I "
			+ "WHERE R.id_impiegato = I.id AND I.dirige IS NOT NULL", nativeQuery = true)
	public abstract List<Recapito> findAllOfDirigenti();
	
	@Query(value = "SELECT R.* FROM recapiti R, impiegati I "
			+ "WHERE R.id_impiegato = I.id AND I.dirige = ?1", nativeQuery = true)
	public abstract List<Recapito> findAllOfDirigente(int id);
	
	@Query(value = "DELETE FROM recapiti WHERE id_impiegato = ?1", nativeQuery = true)
	public abstract void deleteRecapitiOfImpiegato(int id);
	
}
