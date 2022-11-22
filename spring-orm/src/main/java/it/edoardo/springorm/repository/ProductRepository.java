package it.edoardo.springorm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import it.edoardo.springorm.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT P.* FROM products P, users U, orders O, products_orders PO "
			+ "WHERE U.id = O.customer AND O.id = PO.order_id AND PO.product_id = P.id AND U.id = ?1",
			nativeQuery = true)
	public abstract List<Product> findAllProductsOrderedByUser(int id);
	
	@Query(value = "SELECT P.* FROM products P, orders O, products_orders PO "
			+ "WHERE P.id = PO.product_id AND PO.order_id = O.id AND O.id = ?1",
			nativeQuery = true)
	public abstract List<Product> findAllProductsInOrder(int id);
	
	@Query(value = "SELECT P.* FROM products P, orders O, products_orders PO "
			+ "WHERE P.id = PO.product_id AND PO.order_id = O.id AND O.id = 1 AND P.id = ?1 AND O.id = ?2",
			nativeQuery = true)
	public abstract Optional<Product> findByIdAndOrder(int productId, int orderId);
	
	@Query(value = "SELECT P.* FROM products P, orders O, products_orders PO "
			+ "WHERE P.id = PO.product_id AND PO.order_id = O.id AND O.id = 1 AND P.id = ?1 AND U.id = ?2",
			nativeQuery = true)
	public abstract Optional<Product> findByIdAndUser(int productId, int userId);
	
	public abstract List<Product> findAllByPriceLessThanEqual(double price);
	public abstract List<Product> findAllByPriceGreaterThanEqual(double price);
	public abstract List<Product> findAllByPriceBetween(double start, double end);
	
	@Query(value = "DELETE FROM products_orders", nativeQuery = true)
	public abstract void detachProducts();
	
	@Query(value = "DELETE FROM products_orders WHERE product_id = ?1", nativeQuery = true)
	public abstract void detachProduct(int id);
}
