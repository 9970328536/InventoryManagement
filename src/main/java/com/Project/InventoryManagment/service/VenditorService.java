package com.Project.InventoryManagment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Project.InventoryManagment.entity.Venditor;

@Service
public interface VenditorService {

	Venditor saveVenditor(Venditor venditor);

	List<Venditor> getVenditorList();

	Venditor getVenditorById(long id);

	Venditor updateVenditor(long id, Venditor venditor);

	String deleteVenditorById(long id);

	List<Venditor> getVenditorBySuppId(String supId);

	List<Venditor> getBySupAddress(String supAddress);

	List<Venditor> getBySuppName(String supName);


}
