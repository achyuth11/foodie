package com.foody.dao;

import java.util.ArrayList;

import com.foody.model.FdOrder;


public interface FdOrderDAO {
	
	public void saveOrder(FdOrder fdOrder);

	public void cancelOrder(int orderId);

	public ArrayList<FdOrder> getAllOrders(int userId);

}
