package com.EasyBuy.Dao.Order.Impl;

import java.sql.Connection;

import com.EasyBuy.Dao.BaseDao;
import com.EasyBuy.Dao.Order.OrderDetailDao;
import com.EasyBuy.entity.OrderDetail;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao{

	/**
	 * 添加订单详情
	 * @param con
	 * @param orderDetail
	 * @return
	 */
	@Override
	public void add(Connection con, OrderDetail orderDetail) {
		Integer id=0;
		String sql=" insert into easybuy_order_detail(orderId,productId,quantity,cost) values(?,?,?,?) ";
        try {
            Object param[]=new Object[]{orderDetail.getOrderId(),orderDetail.getProductId(),orderDetail.getQuantity(),orderDetail.getCost()};
            id=executeInsert(con,sql,param);//得到订单id
            orderDetail.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}


}
