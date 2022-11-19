package it.edoardo.springdataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import it.edoardo.springdataaccess.model.Order;
import it.edoardo.springdataaccess.model.Product;
import it.edoardo.springdataaccess.model.User;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Order order = new Order();
		final User customer = new User();

		order.setId(resultSet.getInt("id"));

		customer.setId(resultSet.getInt("customer_id"));
		customer.setFirstName(resultSet.getString("first_name"));
		customer.setLastName(resultSet.getString("last_name"));
		customer.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
		customer.setTaxCode(resultSet.getString("tax_code"));

		order.setCustomer(customer);

		List<Product> products = new ArrayList<>();
		do {
			final Product product = new Product();
			product.setId(resultSet.getInt("product_id"));
			product.setName(resultSet.getString("product_name"));
			product.setPrice(resultSet.getDouble("product_price"));
			products.add(product);
		} while((resultSet.getInt("id") == order.getId()) && resultSet.next());

		order.setProducts(products);

		return order;
	}

}
