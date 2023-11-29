package com.EasyBuy.Service.Order;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.Cart;
import com.EasyBuy.entity.Order;
import com.EasyBuy.entity.OrderDetail;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.User;

/**
 * 订单Service接口
 * @author Administrator
 *
 */
public interface OrderService {
	
	/**
	 * 分页查询订单
	 * @param con
	 * @param pageBean
	 * @return
	 */
	public List<Order> list(Connection con,PageBean pageBean,Integer userId);
	
	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con,Integer userId);
	
	/**
	 * 订单id查询该订单详情
	 * @param con
	 * @param orderId
	 * @return
	 */
	public List<OrderDetail> queryOrderDetail(Connection con,Integer orderId);
	
	/**
	 * 添加订单
	 * @param con
	 * @param cart
	 * @param user
	 * @param address
	 * @return
	 */
	public Order insert(Connection con,Cart cart,User user,String address);
}
