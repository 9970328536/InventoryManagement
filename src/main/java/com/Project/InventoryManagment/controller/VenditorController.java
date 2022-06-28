package com.Project.InventoryManagment.controller;

import java.util.List;

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

import com.Project.InventoryManagment.entity.Venditor;
import com.Project.InventoryManagment.service.VenditorService;

@RestController
@RequestMapping("/api/venditor")
public class VenditorController {
	@Autowired
    	VenditorService venditorService;
    	
    @PostMapping
    public ResponseEntity<Venditor> saveVenditor(@RequestBody Venditor venditor){
    	return new ResponseEntity<Venditor>(venditorService.saveVenditor(venditor),HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Venditor> getVenditorList(){
    	return venditorService.getVenditorList();
    }
    
    @GetMapping("/{id}")
    public Venditor getVenditorById(@PathVariable ("id") long id) {
    	return venditorService.getVenditorById(id);
    }
    
    @PutMapping("/{id}")
    public Venditor updateVenditor(@PathVariable ("id")long id,@RequestBody Venditor venditor) {
    	return venditorService.updateVenditor(id,venditor);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenditorById(@PathVariable ("id") long id){
    	return new ResponseEntity<String>(venditorService.deleteVenditorById(id), HttpStatus.CREATED);
    }
    
    @GetMapping("/GetBySupplierId/{supId}")
    public List<Venditor> getVenditorBySupplierId(@PathVariable("supId") String supId){
    	return venditorService.getVenditorBySuppId(supId);
    }
    
    @GetMapping("/GetBySpplierName/{supName}")
    public List<Venditor> getVenditorByName(@PathVariable("supName") String supName){
    	return venditorService.getBySuppName(supName);
    }
    
    @GetMapping("/GetBySupplierAddress/{supAddress}")
    	public List<Venditor> getVenditorByAddress(@PathVariable("supAddress") String supAddress){
    		return venditorService.getBySupAddress(supAddress);
    	}
    }

