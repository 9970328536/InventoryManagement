package com.Project.InventoryManagment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.boot.autoconfigure.cache.CacheType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="SupplierTbl")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Venditor {
    
	@Id
     private long id;
	@NotBlank(message="Id is Mandatory")
     private String supId;
	@NotBlank(message="Supplier Name is Mandatory")
     private String supName;
	@NotBlank(message="Supplier Address is Mandatory")
     private String supAddress;
     private long contactNo;
 	@NotBlank(message="Email is Mandatory")
 	@Email(message="Invalied Email")
     private String email;
     private boolean status;
     
     @OneToMany(mappedBy="venditor",cascade=CascadeType.PERSIST)
 	  @JsonIgnoreProperties("venditor")
 	   private List<Product> products;
        
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSupId() {
		return supId;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
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
	
	public Venditor(long id, @NotBlank(message = "Id is Mandatory") String supId,
			@NotBlank(message = "Supplier Name is Mandatory") String supName,
			@NotBlank(message = "Supplier Address is Mandatory") String supAddress, long contactNo,
			@NotBlank(message = "Email is Mandatory") @Email(message = "Invalied Email") String email, boolean status,
			List<Product> products) {
		super();
		this.id = id;
		this.supId = supId;
		this.supName = supName;
		this.supAddress = supAddress;
		this.contactNo = contactNo;
		this.email = email;
		this.status = status;
		this.products = products;
	}
	
	public Venditor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Venditor [id=" + id + ", supId=" + supId + ", supName=" + supName + ", supAddress=" + supAddress
				+ ", contactNo=" + contactNo + ", email=" + email + ", status=" + status + ", products=" + products
				+ "]";
	}
}
