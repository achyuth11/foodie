package com.foody.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foody.dao.FdOrderDAO;
import com.foody.model.FdOrder;
import com.foody.service.FdOrderService;


@Service("fdOrderService")
@Transactional
public class FdOrderServiceImpl implements FdOrderService {
	
	@Autowired
	private FdOrderDAO fdOrderDAO;

	public void save(FdOrder fdOrder) {
	
		fdOrderDAO.saveOrder(fdOrder);

	}

	public void cancelOrder(int orderId) {
		
		fdOrderDAO.cancelOrder(orderId);		
	}

	public ArrayList<FdOrder> getAllOrders(int userId) {
		
		return fdOrderDAO.getAllOrders(userId);
		
	}

}
