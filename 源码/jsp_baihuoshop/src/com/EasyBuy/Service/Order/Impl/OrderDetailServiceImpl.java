package com.EasyBuy.Service.Order.Impl;

import java.sql.Connection;

import com.EasyBuy.Dao.Order.OrderDetailDao;
import com.EasyBuy.Dao.Order.Impl.OrderDetailDaoImpl;
import com.EasyBuy.Service.Order.OrderDetailService;
import com.EasyBuy.entity.OrderDetail;

public class OrderDetailServiceImpl implements OrderDetailService{

	OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
	
	/**
	 * 添加订单详情
	 */
	@Override
	public void add(Connection con, OrderDetail orderDetail) {
		 orderDetailDao.add(con, orderDetail);
	}

}
