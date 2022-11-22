package it.edoardo.springorm.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.edoardo.springorm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public abstract Optional<User> findByTaxCode(String taxCode);
	public abstract List<User> findAllByDateOfBirthBetween(LocalDate start, LocalDate end);
	public abstract void deleteByTaxCode(String taxCode);
	public abstract void deleteAllByDateOfBirthBetween(LocalDate start, LocalDate end);
}
