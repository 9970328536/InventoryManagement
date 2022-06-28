package com.Project.InventoryManagment.service;

import java.util.List;

import com.Project.InventoryManagment.entity.Product;

public interface ProductService {
	
		Product saveProduct(Product product);
		
		List<Product> getProductList();

		Product getProductById(long id);

		Product UpdateProduct(long id, Product product);

		String deleteProduct(long id);

		List<Product> getProductByName(String productName);

		List<Product> getProductByPrice(double price);

		List<Product> getProductByDescription(String description);

		List<Product> getByProductCode(String prd_code);

}
