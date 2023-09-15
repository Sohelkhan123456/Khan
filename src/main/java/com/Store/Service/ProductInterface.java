package com.Store.Service;

import java.util.List;
import java.util.Optional;

import com.Store.models.Category;
import com.Store.models.Product;

public interface ProductInterface {

	public List<Product> getProducts();
	public List<Product> addProducts(Product products);
	public List<Product> updateProducts(String pname , int pid);
	public List<Product> deleteProducts(int pid);
	public Optional<Product> getIdByProduct(int pid); 
	List<Product> getProducts(Integer page, Integer Size);
	
 	


}
