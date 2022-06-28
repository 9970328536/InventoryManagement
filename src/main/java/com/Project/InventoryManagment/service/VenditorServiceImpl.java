package com.Project.InventoryManagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.InventoryManagment.Exception.AddressNotFoundException;
import com.Project.InventoryManagment.Exception.GivenIdNotFoundException;
import com.Project.InventoryManagment.Exception.GivenNameNotFoundException;
import com.Project.InventoryManagment.Exception.NoRecordFoundException;
import com.Project.InventoryManagment.entity.Venditor;
import com.Project.InventoryManagment.repository.VenditorRepository;
@Service
public class VenditorServiceImpl implements VenditorService{
	@Autowired
	VenditorRepository venditorRepository;
	
	@Override
	public Venditor saveVenditor(Venditor venditor) {
		return venditorRepository.save(venditor);
	}

	@Override
	public List<Venditor> getVenditorList() {
		List<Venditor> venditors = venditorRepository.findAll();
		if(venditors.isEmpty())
			throw new NoRecordFoundException();
		else 
			return venditors;
	}

	@Override
	public  Venditor getVenditorById(long id) {
		Optional<Venditor> venditor = venditorRepository.findById(id);
		if(venditor.isPresent())
		return venditor.get();
		else
			throw new GivenIdNotFoundException();
	}

	@Override
	public Venditor updateVenditor(long id, Venditor venditor) {
		Venditor ven = new Venditor();
		ven = venditorRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException ());
		
		ven.setSupId(venditor.getSupId());
		ven.setSupName(venditor.getSupName());
		ven.setContactNo(ven.getContactNo());
		ven.setEmail(venditor.getEmail());
		ven.setSupAddress(venditor.getSupAddress());
		ven.setStatus(venditor.getStatus());
		 
		venditorRepository.save(ven);
		return ven;
	}

	@Override
	public String deleteVenditorById(long id) {
		Venditor venditor = new Venditor();
		venditor = venditorRepository.findById(id).orElseThrow(()-> new GivenIdNotFoundException());
		   
		venditorRepository.deleteById(id);
		return "Record Deleted Succsessfully";
	}

	@Override
	public List<Venditor> getVenditorBySuppId(String supId) {
		List<Venditor> venditor= venditorRepository.findBySupId(supId);
		if(venditor.isEmpty())
			throw new GivenIdNotFoundException();
		else
			return venditor;
	}

	@Override
	public List<Venditor> getBySupAddress(String supAddress) {
		List<Venditor> venditor = venditorRepository.findBySupAddress(supAddress);
		if(venditor.isEmpty())
			throw new AddressNotFoundException();
		else 
			return venditor;
	}

	@Override
	public List<Venditor> getBySuppName(String supName) {
		List<Venditor> venditor = venditorRepository.findBySupName(supName);
			if(venditor.isEmpty())
				throw new GivenNameNotFoundException();
			else 
			        return venditor;
	}
	
}
