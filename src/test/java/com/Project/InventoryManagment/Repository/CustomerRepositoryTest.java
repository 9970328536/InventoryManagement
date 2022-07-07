package com.Project.InventoryManagment.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Project.InventoryManagment.entity.Customer;
import com.Project.InventoryManagment.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void saveCustomerTest() {
	
	Customer customer = customerRepository.save(new Customer(14,"c1","pooja kande","nashik",5236541223L,"prk@gmail.com"));
			
    Assertions.assertThat(customer.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getProductListTest() {
		List<Customer> customer = customerRepository.findAll();
		
		Assertions.assertThat(customer.size()).isGreaterThan(0);
	}
	
	@Test
	public void getCustomerByIdTest() {
		Customer customer = customerRepository.findById(152L).get();
		
        Assertions.assertThat(customer.getId()).isEqualTo(152L);

	}
	
	@Test
	public void updateCustomerTest() {
		Customer customer = customerRepository.findById(152L).get();
	      
		customer.setAddress("mumbai");
		Customer updated =customerRepository.save(customer);
		
		Assertions.assertThat(updated.getAddress()).isEqualTo("mumbai");
	}
	
	@Test
	public void dleteCustomerTest() {
		 Customer cust = customerRepository.findById(152l).get();
		 customerRepository.delete(cust);
		 
		 Customer customer =null;
		  Optional<Customer> cust1 = customerRepository.findById(152l);
		  
		  if(cust1.isPresent()) {
			  customer = cust1.get();
		  }
		  Assertions.assertThat(customer).isNull();
	}
}



