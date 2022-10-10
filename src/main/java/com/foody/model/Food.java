package com.foody.model;

public class Food {
	private int foodId;
	private String foodName;
	private int unitPrice;
	private int quantity;
	public Food() {
		
	}
	public Food(int foodId, String foodName, int unitPrice) {
		
		this.foodId = foodId;
		this.foodName = foodName;
		this.unitPrice = unitPrice;
		
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + foodId;
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		result = prime * result + unitPrice;
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
		Food other = (Food) obj;
		if (foodId != other.foodId)
			return false;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (unitPrice != other.unitPrice)
			return false;
		return true;
	}
	
	
	

}
