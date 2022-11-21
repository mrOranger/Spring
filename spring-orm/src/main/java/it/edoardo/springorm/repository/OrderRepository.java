package it.edoardo.springorm.repository;

import org.springframework.data.repository.CrudRepository;

import it.edoardo.springorm.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
