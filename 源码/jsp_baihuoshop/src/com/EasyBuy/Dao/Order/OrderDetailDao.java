package com.EasyBuy.Dao.Order;

import java.sql.Connection;

import com.EasyBuy.entity.OrderDetail;

/**
 * 订单详情Dao接口
 * @author Administrator
 *
 */
public interface OrderDetailDao {
	
	/**
	 * 添加订单详情
	 * @param con
	 * @param orderDetail
	 * @return
	 */
	public void add(Connection con,OrderDetail orderDetail);
}
