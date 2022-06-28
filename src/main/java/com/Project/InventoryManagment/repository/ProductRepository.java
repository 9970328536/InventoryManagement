package com.Project.InventoryManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.InventoryManagment.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByProductName(String productName);

	List<Product> findByDescription(String description);
	
	@Query("Select p from ProductTbl p where p.price =:price")
	List<Product> findProductByPrice(@Param("price")double price);

	@Query("Select p from ProductTbl p where p.prd_code =:prd_code")
	List<Product> getByProductCode(@Param("prd_code")String prd_code);

	
}
