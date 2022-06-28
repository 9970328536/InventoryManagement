package com.Project.InventoryManagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.InventoryManagment.Exception.AddressNotFoundException;
import com.Project.InventoryManagment.Exception.ContactNotFoundException;
import com.Project.InventoryManagment.Exception.EmailNotFoundException;
import com.Project.InventoryManagment.Exception.GivenIdNotFoundException;
import com.Project.InventoryManagment.Exception.GivenNameNotFoundException;
import com.Project.InventoryManagment.Exception.NoRecordFoundException;
import com.Project.InventoryManagment.entity.Customer;
import com.Project.InventoryManagment.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customers = customerRepository.findAll();
		
		if(customers.isEmpty()) {
			throw new NoRecordFoundException();
		}else { 
			return customers;
		}}

	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> customer = customer = customerRepository.findById(id);
		
		if(customer.isPresent()) {
		return customer.get();
		}else { 
			throw new GivenIdNotFoundException();
	}
		}
		
	@Override
	public Customer updateCustomer(long id, Customer customer) {
		Customer cust =new Customer();
		cust = customerRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		
		cust.setCustId(customer.getCustId());
		cust.setCustName(customer.getCustName());
		cust.setAddress(customer.getAddress());
		cust.setContactNo(customer.getContactNo());
		cust.setEmail(customer.getEmail());
		
		customerRepository.save(cust);
		return cust;
	}

	@Override
	public String deleteCustomerById(long id) {
		
		Customer customer = new Customer();
		customer = customerRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		customerRepository.deleteById(id);
		return "Record Deleted Successfully";
	}

	@Override
	public List<Customer> getCustomerByCustId(String custId) {
		List<Customer> customer = customerRepository.findByCustId(custId);
		
		if(customer.isEmpty())
			throw new GivenIdNotFoundException();
		else 
			return customer;
	}

	@Override
	public List<Customer> getCustByName(String custName) {
		List<Customer> customer =customerRepository.findByCustName(custName);
		
		if(customer.isEmpty()) {
			throw new GivenNameNotFoundException();
		}else { 
			return customer;
		}
	}

	@Override
	public List<Customer> getCustmerByEmail(String email) {
		List<Customer> customer =  customerRepository.findByEmail(email);
		 if(customer.isEmpty()) {
			 throw new EmailNotFoundException();
		 } else {
			 return customer;
	}}

	@Override
	public List<Customer> getByContactNo(long contactNo) {
		List<Customer> customer= customerRepository.findByContactNo(contactNo);
		 if(customer.isEmpty()) {
			 throw new ContactNotFoundException();
		 }else {
			 return customer;
	}}

	@Override
	public List<Customer> getByAddress(String address) {
		List<Customer> customer = customerRepository.findByAddress(address);
		if(customer.isEmpty()) {
			throw new AddressNotFoundException();
		}else {
			return customer;
	}}
}
