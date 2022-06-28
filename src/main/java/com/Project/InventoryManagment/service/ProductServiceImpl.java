package com.Project.InventoryManagment.service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.InventoryManagment.Exception.GivenIdNotFoundException;
import com.Project.InventoryManagment.Exception.GivenNameNotFoundException;
import com.Project.InventoryManagment.Exception.NoRecordFoundException;
import com.Project.InventoryManagment.Exception.PriceNotFoundException;
import com.Project.InventoryManagment.entity.Product;
import com.Project.InventoryManagment.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;	
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProductList() {
		List<Product> products = productRepository.findAll();
		
		if(products.isEmpty()) {
			throw new NoRecordFoundException();
		}else { 
			return products;
		}
	}

	@Override
	public Product getProductById(long id) {
		Optional<Product> product = productRepository.findById(id);

		if(product.isPresent()) {
			return product.get();
		}else {
			throw new GivenIdNotFoundException();
		}

		}

	@Override
	public Product UpdateProduct(long id, Product product) {
		
		Product prdt = productRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
	
			prdt.setprd_code(product.getprd_code());
			prdt.setproductName(product.getproductName());
			prdt.setdescription(product.getdescription());
			prdt.setprice(product.getprice());
			prdt.setquantity(product.getquantity());
			
			productRepository.save(prdt);
		return prdt;
	}

	@Override
	public String deleteProduct(long id) {
		Optional<Product> product = productRepository.findById(id);

		if(product.isPresent()) {
			productRepository.deleteById(id);
		 }else {
			throw new GivenIdNotFoundException();
		}		
          return "Record is deleted Succsessfuly.";	
	}
	
	@Override
	public List<Product> getByProductCode(String prd_code) {
		
        List<Product> product = productRepository.getByProductCode(prd_code);
		
		if(product.isEmpty()) {
			throw new NoRecordFoundException();
		}else { 
			return product;
		}
	}

	@Override
	public List<Product> getProductByName(String productName) {
       List<Product> product = productRepository.findByProductName(productName);
		
		if(product.isEmpty()) {
			throw  new GivenNameNotFoundException();
		}else { 
			return product;
		}
	}

	@Override
	public List<Product> getProductByDescription(String description) {
		List<Product> product = productRepository.findByDescription(description);
		
		if(product.isEmpty())
			throw new NoRecordFoundException();
		else
			return product;
	}
	
	@Override
	public List<Product> getProductByPrice(double price) {
		List<Product> product = productRepository.findProductByPrice(price);
		
		if(product.isEmpty()) {
			throw new PriceNotFoundException();
		}else {
			return product;
	}
	}
}
