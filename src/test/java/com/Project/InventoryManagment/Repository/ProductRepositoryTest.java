package com.Project.InventoryManagment.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Project.InventoryManagment.entity.Product;
import com.Project.InventoryManagment.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTest {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void saveProductTest() {
		
		Product product = productRepository.save(new Product(25,"P1","tv","42 inch",65544,12, null, null));
		
	          Assertions.assertThat(product.getId()).isGreaterThan(0);
	}
	
    @Test
    public void getProductListTest() {
    	List<Product> product = productRepository.findAll();
    	
    	Assertions.assertThat(product.size()).isGreaterThan(0);
    }
    
    @Test
    public void getPeoductByIdTest() {
    	Product product = productRepository.findById(153L).get();
    	
        Assertions.assertThat(product.getId()).isEqualTo(153L);
    }
    
    @Test
    public void updateProductTest() {
    	Product product = productRepository.findById(152L).get();
    	
    	product.setproductName("Laptop");
    	Product updated = productRepository.save(product);
    	
        Assertions.assertThat(updated.getproductName()).isEqualTo("Laptop");

    }
    
    @Test
    public void deleteProduct() {
    	Product prd = productRepository.findById(152L).get();
    	productRepository.delete(prd);
    	
    	Product product = null;
    	Optional<Product> prd1 = productRepository.findById(152l);
    	
    	if(prd1.isPresent()) {
    		product = prd1.get();
    	}
    	Assertions.assertThat(product).isNull();
    }
}















