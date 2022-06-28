package com.Project.InventoryManagment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="SupplierTbl")
public class Venditor {
    
	@Id
	@NotBlank()
     private long id;
     private String supId;
     private String supName;
     private String supAddress;
     private long contactNo;
     private String email;
     private boolean status;
     
     @OneToMany(mappedBy="venditor",cascade= CascadeType.ALL)
     @JsonIgnoreProperties("venditor")
     private List<Product> products; 
     
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Product> getProduct() {
		return products;
	}
	public void setProduct(List<Product> product) {
		this.products = product;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupAddress() {
		return supAddress;
	}
	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Venditor(long id, String supId, String supName, String supAddress, long contactNo, String email,
			boolean status, List<Product> product) {
		super();
		this.id = id;
		this.supId = supId;
		this.supName = supName;
		this.supAddress = supAddress;
		this.contactNo = contactNo;
		this.email = email;
		this.status = status;
		this.products = product;
	}
	public Venditor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Venditor [id=" + id + ", supId=" + supId + ", supName=" + supName + ", supAddress=" + supAddress
				+ ", contactNo=" + contactNo + ", email=" + email + ", status=" + status + ", product=" + products + "]";
	}
}
