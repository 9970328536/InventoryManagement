package com.Project.InventoryManagment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Project.InventoryManagment.entity.Purchase;

@Repository
@Component
public interface PurchaseRepository extends JpaRepository<Purchase,Long>{

	List<Purchase> findByPurchaseId(long purchaseId);

	List<Purchase> findByProductName(String productName);

	List<Purchase> findByTotalCost(double totalCost);

	List<Purchase> findByDate(Date date);

}
