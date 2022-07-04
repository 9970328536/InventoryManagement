package com.Project.InventoryManagment.entity;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="purchaseTbl")

public class Purchase  {
     
	@Id
	@GeneratedValue(generator="seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name= "seq", initialValue=1001)
	private long id;
	private long purchaseId;
	private LocalDateTime date;
	@NotBlank(message="Product Name maintion")
	private String productName;
	@NotBlank(message="Quantity is Mandatory")
	private String quantity;
	private double unitPrice;
	private double totalCost;
	
	@ManyToOne(fetch=FetchType.LAZY)
	 @JsonIgnore	
	 private Customer customer;
	
	@PrePersist
	public void addDate() {
		this.date= LocalDateTime.now();
		this.customer=getCustomer();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	public Purchase(long id, long purchaseId, LocalDateTime date,
			@NotBlank(message = "Product Name maintion") String productName,
			@NotBlank(message = "Quantity is Mandatory") String quantity, double unitPrice, double totalCost,
			Customer customer) {
		super();
		this.id = id;
		this.purchaseId = purchaseId;
		this.date = date;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalCost = totalCost;
		this.customer = customer;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseId=" + purchaseId + ", date=" + date + ", productName=" + productName
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalCost=" + totalCost + ", customer="
				+ customer + "]";
	}
	
}
