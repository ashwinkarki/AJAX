package com.ashwin.springwebstuck.dao;

import java.util.List;

import com.ashwin.springwebstuck.entity.Category;
import com.ashwin.springwebstuck.entity.Product;

public interface ProductDAO {
    
	Product getById(int productId);
	List<Product> getAllProduct();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	//businees methos
	List<Product> listActiveProduct();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	
	
}
