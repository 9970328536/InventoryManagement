package com.Project.InventoryManagment.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.Project.InventoryManagment.Exception.GivenIdNotFoundException;
import com.Project.InventoryManagment.Exception.NoRecordFoundException;
import com.Project.InventoryManagment.Exception.RecordAlreadyExistException;
import com.Project.InventoryManagment.entity.Product;
import com.Project.InventoryManagment.repository.ProductRepository;
import com.Project.InventoryManagment.service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;
	
	@Autowired
	@InjectMocks
	private ProductServiceImpl productService;
	
	private Product product;
	
	private Product product1;
	private Product product2;
	List<Product> productList;
	
	@BeforeEach
	public void serUp() {
		productList = new ArrayList<>();
		
		product1 = new Product(102,"p2","Tv","42 Inch");
		product2 = new Product(103,"p3","mobile","64gb");
		
		productList.add(product1);
		productList.add(product2);
	}
	
	@AfterEach
	public void afterTest() {
		product1 = product2= null;
		productList =null;
	}
	
	@DisplayName("Test For saveProduct() method")
	@Test
	public void givenProductToAddShouldReturnAddProduct() {
           when(productRepository.save(product1)).thenReturn(product1);
				
		Product savedProduct = productService.saveProduct(product1);
		
		System.out.println(savedProduct);
		assertThat(savedProduct).isNotNull();
		
	}
	
	@Test
    public void givenExistingIdWhenSaveProductThenThrowsException(){
    	
    	Product product = new Product(102,"p5","Tv","42 Inch");
    	
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        
        
       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> { productService.saveProduct(product);
    	   });
    }


    // To test getProductList() method
	@Test
	public void givenGetAllProductsShouldReturnListOfAllProducts()throws NoRecordFoundException {
		
		productRepository.saveAll(productList);
		
		when(productRepository.findAll()).thenReturn(productList);
		
		List<Product> actualProductList = productService.getProductList();
		
		assertThat(actualProductList).isEqualTo(productList);
		
	}
	
	@Test
	public void givenIdThenShouldReturnProductOfThatId() throws GivenIdNotFoundException{
		
		when(productRepository.findById(102L)).thenReturn(Optional.ofNullable(product1));
		assertThat(productService.getProductById(product1.getId())).isEqualTo(product1);
		
	}
	
	@Test
	public void givenIdToDeleteThenShouldDeleteProductOfThatId() {
		when(productRepository.findById(product1.getId())).thenReturn(Optional.ofNullable(product1));
		
        assertThat(productService.deleteProduct(product1.getId())).isEqualTo("Record is deleted Succsessfuly.");
	}
	
	@Test
	public void givenIdToDeleteNotExistThenThrowsException()  {
		long productId = 102L;
		 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () -> 
	    {
        productService.deleteProduct(productId);
         });

	} 
	
    @DisplayName("JUnit test for updateProduct method")
    @Test
    public void givenProductObject_whenUpdateProduct_thenReturnUpdatedProduct(){
    	long id = 102L;
        when(productRepository.save(product1)).thenReturn(product1);
        when(productRepository.findById(id)).thenReturn(Optional.of(product1));
        product1.setdescription("42 Inch");
        product1.setproductName("SamsungTV");
        Product updateProduct = productService.UpdateProduct(id, product1);

        assertThat(updateProduct.getdescription()).isEqualTo("42 Inch");
        assertThat(updateProduct.getproductName()).isEqualTo("SamsungTV");

    }
    
    @Test
	public void givenIdToUpdateNotExistThenThrowsException()  {
		long productId = 102L;

		Product product= new Product();
		product1.setdescription("42 Inch");
		product1.setproductName("SamsungTV");
        
		 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () ->
		 {
        productService.UpdateProduct(productId, product);
		 } 
		 );

	} 


}
