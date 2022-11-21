package it.edoardo.springorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.edoardo.springorm.model.Order;
import it.edoardo.springorm.model.Product;
import it.edoardo.springorm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT P.id, P.name, P.price FROM products P, orders O, products_orders PO, users U "
			+ "WHERE U.id = O.customer AND O.id = PO.order_id AND PO.product_id = P.id AND U.id = ?1")
	public abstract List<Product> findUserProducts(int id);
	
	@Query(value = "SELECT O.id, C.id, C.first_name, C.last_name, C.date_of_birth, C.tax_code, P.id, P.name, P.price "
			+ "FROM users C, orders O, products P, products_orders PO "
			+ "WHERE U.id = ?1 AND U.id = O.customer AND O.order_id = OP.order_id AND OP.product_id = P.id")
	public abstract List<Order> findUserOrders(int id);
	
	@Query(value = "SELECT O.id, C.id, C.first_name, C.last_name, C.date_of_birth, C.tax_code, P.id, P.name, P.price "
			+ "FROM users C, orders O, products P, products_orders PO "
			+ "WHERE U.id = ?1 AND P.id = ?2, AND U.id = O.customer AND O.order_id = OP.order_id AND OP.product_id = P.id")
	public abstract Product findUserProduct(int userId, int productId);
	
}
