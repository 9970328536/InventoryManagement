package com.Project.InventoryManagment.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.InventoryManagment.entity.Product;
import com.Project.InventoryManagment.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductService productService;
		
	@PostMapping
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Product> getProductList() {
		return productService.getProductList();
	}
	
	@GetMapping("/{id}")
      public Product getProductById(@PathVariable("id")long id){
		return productService.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product UpdateProduct(@PathVariable("id")long id,@Valid @RequestBody Product product) {
	return productService.UpdateProduct(id,product);
}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable ("id") long id) {
		return new ResponseEntity<String>(productService.deleteProduct(id), HttpStatus.CREATED);
	}
	
	@GetMapping("/GetByProductCode/{prd_code}")
	public List<Product> getProductByProductCode(@PathVariable("prd_code")String prd_code){
		return productService.getByProductCode(prd_code);
	}
	
		
	@GetMapping("/GetByProductName/{productName}")
	public List<Product> getProductByName(@PathVariable ("productName") String productName){
		return productService.getProductByName(productName);
	}
		
	@GetMapping("/GetByDescription/{productName}/{description}")
	public List<Product> getProductByDescription(@PathVariable("description")String description){
		return productService.getProductByDescription(description);
	}
	
	@GetMapping("/GetByProductPrice/{price}")
	public List<Product> getProductByPrice(@PathVariable("price") double price){
		return productService.getProductByPrice(price);
	}

}