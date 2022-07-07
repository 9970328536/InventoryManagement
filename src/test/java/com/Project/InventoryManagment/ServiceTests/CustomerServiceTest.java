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
import com.Project.InventoryManagment.entity.Customer;
import com.Project.InventoryManagment.repository.CustomerRepository;
import com.Project.InventoryManagment.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Autowired
	@InjectMocks
	private CustomerServiceImpl customerService;

	private Customer customer;
	
	private Customer customer1;
	private Customer customer2;
	List<Customer> customerList;

	@BeforeEach
	public void serUp() {
		customerList = new ArrayList<>();
		
		customer1 = new Customer(1002,"c1","Shweta Kande","Nashik");
		customer2 = new Customer(1003,"c2","Meena Kande","Yeola");
		
		customerList.add(customer1);
		customerList.add(customer2);
	}
	
	@AfterEach
	public void afterTest() {
		customer1 = customer2= null;
		customerList =null;
	}
	
	
	@DisplayName("Test For saveCustomer() method")
	@Test
	public void givenCustomerToAddShouldReturnAddCustomer() {
           when(customerRepository.save(customer1)).thenReturn(customer1);
				
		Customer savedCustomer = customerService.saveCustomer(customer1);
		
		System.out.println(savedCustomer);
		assertThat(savedCustomer).isNotNull();		
	}
	
	@Test
  public void givenExistingIdWhenSaveCustomerThenThrowsException(){
  	
  	Customer customer = new Customer(1002,"c1","Shweta Kande","Nashik");

      when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
      
      
     org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> { customerService.saveCustomer(customer);
  	   });
  }
	
	// To test getCustomerList() method
		@Test
		public void givenGetAllCustomerShouldReturnListOfAllCustomers()throws NoRecordFoundException {
			
			customerRepository.saveAll(customerList);
			
			when(customerRepository.findAll()).thenReturn(customerList);
			
			List<Customer> actualCustomerList = customerService.getCustomerList();
			
			assertThat(actualCustomerList).isEqualTo(customerList);
			
		}
		
		@Test
		public void givenIdThenShouldReturnCustomerOfThatId() throws GivenIdNotFoundException{
			
			when(customerRepository.findById(1002L)).thenReturn(Optional.ofNullable(customer1));
			assertThat(customerService.getCustomerById(customer1.getId())).isEqualTo(customer1);
			
		}
		
		@Test
		public void givenIdToDeleteThenShouldDeleteCustomerOfThatId() {
			when(customerRepository.findById(customer1.getId())).thenReturn(Optional.ofNullable(customer1));
			
	        assertThat(customerService.deleteCustomerById(customer1.getId())).isEqualTo("Record Deleted Successfully");
		}
		
		@Test
		public void givenIdToDeleteNotExistThenThrowsException()  {
			long customerId = 1002L;
			 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () -> 
		    {
	        customerService.deleteCustomerById(customerId);
	         });
		}
		    @DisplayName("JUnit test for updateCustomer method")
		    @Test
		    public void givenCustomerObject_whenUpdateCustomer_thenReturnUpdatedCustomer(){
		    	long id = 1002L;
		        when(customerRepository.save(customer1)).thenReturn(customer1);
		        when(customerRepository.findById(id)).thenReturn(Optional.of(customer1));
		        customer1.setEmail("pooja@gmail.com");
		        customer1.setAddress("Nashik");
		        Customer updateCustomer = customerService.updateCustomer(id, customer1);
		
		        assertThat(updateCustomer.getEmail()).isEqualTo("pooja@gmail.com");
		        assertThat(updateCustomer.getAddress()).isEqualTo("Nashik");
		
		    }
		    
		    @Test
			public void givenIdToUpdateNotExistThenThrowsException()  {
				long customerId = 1002L;
		
				Customer customer= new Customer();
		        customer1.setEmail("pooja@gmail.com");
		        customer1.setAddress("Nashik");
		        
				 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () ->
				 {
		        customerService.updateCustomer(customerId, customer);
				 } 
				 );
		} 
} 






















