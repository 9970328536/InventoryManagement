package com.Project.InventoryManagment.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="ProductTbl")
public class Product {
	
	@Id
	@GeneratedValue(generator="seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name= "seq", initialValue=1)
	private long id;
	@Column(nullable=false)
	@NotBlank(message="code is Mandatory")
	 private String prd_code;
	@Column(nullable=false)
	@NotBlank(message="Product name is Mandatory")
	 private String productName;
	@Column(nullable=false)
	@NotBlank(message="Description is Mandatory")
	 private String description;
	 private double price;
	 private int quantity;
	 
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JsonIgnore
	 private Venditor venditor;
	 
	 @ManyToMany(mappedBy="product")
	 @JsonIgnore
	 private List<Customer> customer; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getprd_code() {
		return prd_code;
	}

	public void setprd_code(String prd_code) {
		this.prd_code = prd_code;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Venditor getVenditor() {
		return venditor;
	}

	public void setVenditor(Venditor venditor) {
		this.venditor = venditor;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	public Product(long id, @NotBlank(message = "code is Mandatory") String prd_code,
			@NotBlank(message = "Product name is Mandatory") String productName,
			@NotBlank(message = "Description is Mandatory") String description, double price, int quantity,
			Venditor venditor, List<Customer> customer) {
		super();
		this.id = id;
		this.prd_code = prd_code;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.venditor = venditor;
		this.customer = customer;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prd_code=" + prd_code + ", productName=" + productName + ", description="
				+ description + ", price=" + price + ", quantity=" + quantity + ", venditor=" + venditor + ", customer="
				+ customer +"]";
	}
		}
