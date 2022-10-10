package com.foody.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="fd_order_items")
public class FdOrderItems {
	@Id
	@Column(name="count_id")
	@SequenceGenerator(name="fd_order_detail_seq",sequenceName = "fd_order_detail_id_sequence")
	@GeneratedValue(strategy = GenerationType.AUTO ,generator="fd_order_detail_seq")
	private int countId;
	
	@Column(name="order_id")
	private int orderID;
	@Column(name="food_id")
	private int foodId;
	@Column(name="quantity")
	private int quantity;
	@Column(name="unit_price")
	private int unit_price;
	
	
	public FdOrderItems() {
		
	}

	public FdOrderItems(int orderID, int foodId, int quantity, int unit_price) {
		this.orderID = orderID;
		this.foodId = foodId;
		this.quantity = quantity;
		this.unit_price = unit_price;
	}



	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getCountId() {
		return countId;
	}

	public void setCountId(int countId) {
		this.countId = countId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + foodId;
		result = prime * result + orderID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FdOrderItems other = (FdOrderItems) obj;
		if (foodId != other.foodId)
			return false;
		if (orderID != other.orderID)
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "FdOrderItems [orderID=" + orderID + ", foodId=" + foodId + "]";
	}
	
	

}
