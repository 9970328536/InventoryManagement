package com.Project.InventoryManagment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.InventoryManagment.Exception.CostNotFoundException;
import com.Project.InventoryManagment.Exception.GivenIdNotFoundException;
import com.Project.InventoryManagment.Exception.GivenNameNotFoundException;
import com.Project.InventoryManagment.Exception.NoRecordFoundException;
import com.Project.InventoryManagment.Exception.RecordAlreadyExistException;
import com.Project.InventoryManagment.entity.Purchase;
import com.Project.InventoryManagment.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Override
	public Purchase savePurchase(Purchase purchase) {
		Optional<Purchase> pur = purchaseRepository.findById(purchase.getId());
		if(!pur.isPresent()){
		return purchaseRepository.save(purchase);
		}else {
			throw new RecordAlreadyExistException();
		}
	}

	@Override
	public List<Purchase> getPurchaseList() {
		List<Purchase> purchases = purchaseRepository.findAll();
		
		if(purchases.isEmpty()) {
			throw new NoRecordFoundException();
		}else { 
			return purchases;
				}
		}

	@Override
	public Purchase getPurchaseById(long id) {
		Optional<Purchase> purchase = purchaseRepository.findById(id);
		if(purchase.isPresent())
			return purchase.get();
		else
		    throw new GivenIdNotFoundException();
	}

	@Override
	public Purchase updatePurchaseById(long id, Purchase purchase) {
		Purchase pur = new Purchase();
		pur = purchaseRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		
		pur.setPurchaseId(purchase.getPurchaseId());
		pur.setProductName(purchase.getProductName());
		pur.setQuantity(purchase.getQuantity());
		pur.setUnitPrice(purchase.getUnitPrice());
		pur.setTotalCost(purchase.getTotalCost());
		
		purchaseRepository.save(pur);
		return pur;
	}

	@Override
	public String deletePurchaseById(long id) {
		Purchase purchase = new Purchase();
		purchase = purchaseRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		purchaseRepository.delete(purchase);
		return "Record Deleted Sucsessfully";
	}

	@Override
	public List<Purchase> getByPurchaseId(long purchaseId) {
		List<Purchase> purchase = purchaseRepository.findByPurchaseId(purchaseId);
		if(purchase.isEmpty())
			throw new GivenIdNotFoundException();
		else
			return purchase;
	}

	@Override
	public List<Purchase> getByProductName(String productName) {
		List<Purchase> purchase = purchaseRepository.findByProductName(productName);
		if(purchase.isEmpty())
			throw new GivenNameNotFoundException();
		else
			return purchase;
	}

	@Override
	public List<Purchase> getByTotalCost(double totalCost) {
		List<Purchase> purchase = purchaseRepository.findByTotalCost(totalCost);
		if(purchase.isEmpty())
			throw new CostNotFoundException();
		else
			return purchase;
	}

	@Override
	public List<Purchase> getByDate(LocalDate date) {
			System.out.println(date);
	         return purchaseRepository.findByDate(date);
	}

}













