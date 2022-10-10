package com.foody.dao.impl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.foody.dao.FdOrderDAO;
import com.foody.model.FdOrder;

@Repository("fdOrderDAO")
public class FdOrderDAOImpl extends AbstractDao implements FdOrderDAO {

	public void saveOrder(FdOrder fdOrder) {
		persist(fdOrder);
	}

	public void cancelOrder(int orderId) {

		Criteria criteria = getSession().createCriteria(FdOrder.class);
		criteria.add(Restrictions.eq("id", orderId));

		FdOrder fdUser = (FdOrder) criteria.uniqueResult();

		fdUser.setOrderStatus("Cancelled");

	}

	public ArrayList<FdOrder> getAllOrders(int userId) {
		
		Criteria criteria = getSession().createCriteria(FdOrder.class);
		criteria.add(Restrictions.eq("custId", userId));

		ArrayList<FdOrder> userOrders = (ArrayList<FdOrder>) criteria.list();
		
		return userOrders;
		
	}

}
