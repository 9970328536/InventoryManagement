package com.Project.InventoryManagment.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customerTbl")
public class Customer  {
	 
	@Id
	@GeneratedValue(generator="seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name= "seq", initialValue=501)
	private long id;
	@Column(nullable=false)
	@NotBlank(message="Id is Mandatory")
	private String custId;
	@Column(nullable=false)
	@NotBlank(message="Name is Mandatory")
	private String custName;
	@Column(nullable=false)
	@NotBlank(message="Address is Mandatory")
	private String address;
	private long contactNo;
	@NotBlank(message="Email is Mandatory")
	@Email(message="Invalied Email")
	private String email;
	
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Purchase> purchase;
	
	@ManyToMany
	@JoinTable(name="customer_product", joinColumns= @JoinColumn(name="custid"), inverseJoinColumns= @JoinColumn(name="prdid"))
	@JsonIgnore
	private List<Product> product;
	
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
	
	public List<Purchase> getPurchase() {
		return purchase;
	}
	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	public Customer(long id, @NotBlank(message = "Id is Mandatory") String custId,
			@NotBlank(message = "Name is Mandatory") String custName,
			@NotBlank(message = "Address is Mandatory") String address, long contactNo,
			@NotBlank(message = "Email is Mandatory") @Email(message = "Invalied Email") String email,
			List<Purchase> purchase, List<Product> product) {
		super();
		this.id = id;
		this.custId = custId;
		this.custName = custName;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.purchase = purchase;
		this.product = product;
	}
	public Customer(long id, @NotBlank(message = "Id is Mandatory") String custId,
			@NotBlank(message = "Name is Mandatory") String custName,
			@NotBlank(message = "Address is Mandatory") String address, long contactNo,
			@NotBlank(message = "Email is Mandatory") @Email(message = "Invalied Email") String email) {
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
				+ ", contactNo=" + contactNo + ", email=" + email + ", purchase=" + purchase + ", product=" + product
				+ "]";
	}
}
