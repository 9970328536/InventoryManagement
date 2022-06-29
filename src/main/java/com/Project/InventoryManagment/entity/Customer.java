package com.Project.InventoryManagment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="CustomerTbl")
public class Customer {
	 
	@Id
	private long id;
	@NotBlank(message="Id is Mandatory")
	private String custId;
	@NotBlank(message="Name is Mandatory")
	private String custName;
	@NotBlank(message="Address is Mandatory")
	private String address;
	private long contactNo;
	@NotBlank(message="Email is Mandatory")
	@Email(message="Invalied Email")
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public Customer(long id, String custId, String custName, String address, long contactNo, String email,
			List<Product> products) {
		super();
		this.id = id;
		this.custId = custId;
		this.custName = custName;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custId=" + custId + ", custName=" + custName + ", address=" + address
				+ ", contactNo=" + contactNo + ", email=" + email + "]";
	}
}
