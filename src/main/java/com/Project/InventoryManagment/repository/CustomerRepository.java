package com.Project.InventoryManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Project.InventoryManagment.entity.Customer;
@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer , Long> {

	List<Customer> findByCustId(String custId);
	
//	@Query("Select c from Customer c where c.custName =: custName")
	List<Customer> findByCustName(String custName);

	List<Customer> findByEmail(String email);

	List<Customer> findByContactNo(long contactNo);

	List<Customer> findByAddress(String address);


}

//@Query("Select p from ProductTbl p where p.price =:price")
//List<Product> findProductByPrice(@Param("price")double price);
