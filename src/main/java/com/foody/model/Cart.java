package com.foody.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
	private int userId;
	private int restaurantId;
	private ArrayList<Food> foods;
	
	public Cart() {
		this.foods=new ArrayList<Food>();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public ArrayList<Food> getFoods() {
		return foods;
	}
	public void  setFoods(ArrayList<Food> fds) {
		foods.addAll(fds);
	}
	public Food getFoodById(int id)
	{
		Iterator<Food> it=foods.iterator();
		while(it.hasNext())
		{
			Food f=it.next();
			if(f.getFoodId()==id)
			{
				return f;
			}
		}
		return null;
	}
	
	
	

}
