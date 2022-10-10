package com.foody.dao.impl;

import org.springframework.stereotype.Repository;

import com.foody.dao.FdOrderItemDAO;
import com.foody.model.FdOrderItems;


@Repository("fdOrderDetailsDAO")
public class FdOrderItemDAOImpl extends AbstractDao implements FdOrderItemDAO {

	public void saveOrderDetails(FdOrderItems fdOrderItems) {
		persist(fdOrderItems);
	}

}
