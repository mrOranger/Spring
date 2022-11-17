package it.edoardo.springdataaccess.dao.interfaces;

import java.util.List;

import it.edoardo.springdataaccess.model.Product;

public interface ProductDAO {
	
	public abstract List<Product> getProducts();
	public abstract Product getProduct(int id);
	public abstract void addProduct(Product product);
	public abstract void updateProducts(List<Product> products);
	public abstract void updateProduct(int id, Product product);
	public abstract void deleteProducts();
	public abstract void deleteProduct(int id);

}
