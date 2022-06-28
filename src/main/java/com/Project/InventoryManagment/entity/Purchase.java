package com.Project.InventoryManagment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="purchaseTbl")
public class Purchase {
     @Id
	private long id;
	private long purchaseId;
	private Date date;
	private String productName; 
	private String quantity;
	private double unitPrice;
	private double totalCost;
	
	@OneToOne(mappedBy="purchase")
	private Customer customer;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	public Purchase(long id, long purchaseId, Date date, String productName, String quantity, double unitPrice,
			double totalCost) {
		super();
		this.id = id;
		this.purchaseId = purchaseId;
		this.date = date;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalCost = totalCost;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseId=" + purchaseId + ", date=" + date + ", productName=" + productName
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalCost=" + totalCost + "]";
	}
	
}
