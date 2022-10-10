package com.foody.service;

import java.util.ArrayList;

import com.foody.model.FdOrder;



public interface FdOrderService {
	public void save(FdOrder fdOrder);

	public void cancelOrder(int orderId);

	public ArrayList<FdOrder> getAllOrders(int userId);

}
