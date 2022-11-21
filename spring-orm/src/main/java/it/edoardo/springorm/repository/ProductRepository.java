package it.edoardo.springorm.repository;

import org.springframework.data.repository.CrudRepository;

import it.edoardo.springorm.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
