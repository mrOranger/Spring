package it.edoardo.springorm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.edoardo.springorm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query(value = "SELECT * FROM orders WHERE customer = ?1", nativeQuery = true)
	public abstract List<Order> findAllByCustomer(int customer);
	
	@Query(value = "SELECT O.* FROM orders O, products_orders PO, products P "
			+ "WHERE O.id = PO.order_id AND PO.product_id = P.id AND P.id = ?1", nativeQuery = true)
	public abstract List<Order> findAllByProduct(int id);
	
	@Query(value = "SELECT O.* FROM orders O, products_orders PO, products P "
			+ "WHERE O.id = PO.order_id AND PO.product_id = P.id AND P.id = ?1 AND O.id = ?2", nativeQuery = true)
	public abstract Optional<Order> findByProduct(int product, int order);
	
	@Query(value = "INSERT INTO products_orders VALUES (?1, ?2)", nativeQuery = true)
	public abstract void saveProductInOrder(int order, int product);
	
	@Query(value = "DELETE FROM products_orders", nativeQuery = true)
	public abstract void deleteAllProductsFromOrders();
	
	@Query(value = "DELETE FROM products_orders WHERE order_id = ?1", nativeQuery = true)
	public abstract void deleteAllProductsFromOrder(int id);
	
	@Query(value = "DELETE FROM products_orders WHERE order_id = ?1 AND product_id = ?2", nativeQuery = true)
	public abstract void deleteProductFromOrder(int order, int product);

}
