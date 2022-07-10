package com.Project.InventoryManagment.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;


@Entity(name="ProductTbl")
public class Product {
	
	@Id
	@GeneratedValue(generator="seq1", strategy=GenerationType.AUTO)
	@SequenceGenerator(name= "seq1", initialValue=101)
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
	
	
	public Product(long id, @NotBlank(message = "code is Mandatory") String prd_code,
			@NotBlank(message = "Product name is Mandatory") String productName,
			@NotBlank(message = "Description is Mandatory") String description, double price, int quantity) {
		super();
		this.id = id;
		this.prd_code = prd_code;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}



	public Product(long id, @NotBlank(message = "code is Mandatory") String prd_code,
			@NotBlank(message = "Product name is Mandatory") String productName,
			@NotBlank(message = "Description is Mandatory") String description) {
		super();
		this.id = id;
		this.prd_code = prd_code;
		this.productName = productName;
		this.description = description;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prd_code=" + prd_code + ", productName=" + productName + ", description="
				+ description + ", price=" + price + ", quantity=" + quantity + "]";
	}
		}
