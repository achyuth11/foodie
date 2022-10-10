package com.foody.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foody.dao.FdOrderItemDAO;
import com.foody.model.FdOrderItems;
import com.foody.service.FdOrderItemService;

@Service("fdOrderDetailService")
@Transactional
public class FdOrderItemServiceImpl implements FdOrderItemService {
	
	@Autowired
	private FdOrderItemDAO fdOrderDetailsDAO;

	public void save(FdOrderItems fdOrderItems) {
		
		fdOrderDetailsDAO.saveOrderDetails(fdOrderItems);;
	}

}
