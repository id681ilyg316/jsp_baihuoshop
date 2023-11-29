package com.EasyBuy.Service.Order;

import java.sql.Connection;

import com.EasyBuy.entity.OrderDetail;

public interface OrderDetailService {
	
	/**
	 * 添加订单详情
	 * @param con
	 * @param orderDetail
	 * @return
	 */
	public void add(Connection con,OrderDetail orderDetail);
}
