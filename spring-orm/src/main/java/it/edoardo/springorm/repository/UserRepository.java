package it.edoardo.springorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.edoardo.springorm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
