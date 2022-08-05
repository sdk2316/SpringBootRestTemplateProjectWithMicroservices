package com.durgesh.model;

import java.util.Random;


public class OrderDetails {
	
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	//private Integer pnr=  new Random().nextInt(99999999);
	private Integer orderId=  new Random().nextInt(99999999);

	private String customerName;
	private String orderName;
	private Double price;
	private String brand;
	private Boolean isActive;
	public OrderDetails() {
		super();
		
	}
	
	

	public OrderDetails(Integer orderId, String customerName, String orderName, Double price, String brand,
			Boolean isActive) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderName = orderName;
		this.price = price;
		this.brand = brand;
		this.isActive = isActive;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public Integer getOrderId() {
		return orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getOrderName() {
		return orderName;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", customerName=" + customerName + ", orderName=" + orderName
				+ ", price=" + price + ", brand=" + brand + ", isActive=" + isActive + "]";
	}

	
	
	
}
