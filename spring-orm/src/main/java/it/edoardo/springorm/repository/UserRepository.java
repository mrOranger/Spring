package it.edoardo.springorm.repository;

import org.springframework.data.repository.CrudRepository;

import it.edoardo.springorm.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
