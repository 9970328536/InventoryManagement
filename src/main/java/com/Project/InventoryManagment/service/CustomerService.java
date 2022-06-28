package com.Project.InventoryManagment.service;

import java.util.List;

import com.Project.InventoryManagment.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getCustomerList();

	Customer getCustomerById(long id);

	Customer updateCustomer(long id, Customer customer);

	String deleteCustomerById(long id);

	List<Customer> getCustomerByCustId(String custId);

	List<Customer> getCustByName(String custName);

	List<Customer> getCustmerByEmail(String email);

	List<Customer> getByContactNo(long contactNo);

	List<Customer> getByAddress(String address);

}
