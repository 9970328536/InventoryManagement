package com.Project.InventoryManagment.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.Project.InventoryManagment.entity.Purchase;

public interface PurchaseService {

	Purchase savePurchase(Purchase purchase);

	List<Purchase> getPurchaseList();

	Purchase getPurchaseById(long id);

	Purchase updatePurchaseById(long id, Purchase purchase);

	String deletePurchaseById(long id);

	List<Purchase> getByPurchaseId(long purchaseId);

	List<Purchase> getByProductName(String productName);

	List<Purchase> getByTotalCost(double totalCost);

	List<Purchase> getByDate(LocalDate date);

}
