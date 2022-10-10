package com.foody.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="fd_order")
public class FdOrder {
	@Id
	@Column(name="order_id")
	@SequenceGenerator(name="fd_order_seq",sequenceName = "fd_order_id_sequence")
	@GeneratedValue(strategy = GenerationType.AUTO ,generator="fd_order_seq")
	private int id;
	@Column(name="fd_user_id")
	private int custId;
	@Column(name="fd_user_id_delivaer_partner")
	private int delId;
	@Column(name="restaurant_id")
	private int restId;
	@Column(name="order_status")
	private String orderStatus;
	@Column(name="total_price")
	private Double totalPrice;
	
	
	public FdOrder() {
	}
	
	public FdOrder(int custId, int delId, int restId, String orderStatus, Double totalPrice) {
		this.custId = custId;
		this.delId = delId;
		this.restId = restId;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getDelId() {
		return delId;
	}
	public void setDelId(int delId) {
		this.delId = delId;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
		result = prime * result + delId;
		result = prime * result + id;
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + restId;
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
		FdOrder other = (FdOrder) obj;
		if (custId != other.custId)
			return false;
		if (delId != other.delId)
			return false;
		if (id != other.id)
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (restId != other.restId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FdOrder [id=" + id + ", custId=" + custId + ", delId=" + delId + ", restId=" + restId + ", orderStatus="
				+ orderStatus + "]";
	}
	
	
}
