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

import com.Project.InventoryManagment.entity.Customer;
import com.Project.InventoryManagment.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Customer> getCustomerList(){
		return customerService.getCustomerList();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable ("id")long id) {
		return customerService.getCustomerById(id);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable ("id") long id ,@RequestBody Customer customer) {
		return customerService.updateCustomer(id,customer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable ("id") long id){
		return new ResponseEntity<String>(customerService.deleteCustomerById(id), HttpStatus.CREATED);
	}
	
	@GetMapping("/GetByCustomerId/{custId}")
	public List<Customer> getCustomerByCustId(@PathVariable("custId") String custId){
		return customerService.getCustomerByCustId(custId);
	}
	
	@GetMapping("/GetByCustomerName/{custName}")
	public List<Customer> getCustomerByName(@PathVariable("custName") String custName){
		return customerService.getCustByName(custName);
	}
	
	@GetMapping("/GetByCustomerEmail/{email}")
	public List<Customer> getCustomerByEmail(@PathVariable("email") String email){
		return customerService.getCustmerByEmail(email);
	}
	
	@GetMapping("/GetByCustomerContactNo/{contactNo}")
	public List<Customer> getCustomerByContactNo(@PathVariable("contactNo") long contactNo){
		return customerService.getByContactNo(contactNo);
	}
	
	@GetMapping("/GetByCustomerAddress/{address}")
	public List<Customer> getCustomerByAddress(@PathVariable("address") String address){
		return customerService.getByAddress(address);
	}
	}
