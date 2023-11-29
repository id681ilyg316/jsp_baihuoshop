package com.EasyBuy.Service.Order.Impl;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.Dao.Order.OrderDao;
import com.EasyBuy.Dao.Order.Impl.OrderDaoImpl;
import com.EasyBuy.Service.Order.OrderDetailService;
import com.EasyBuy.Service.Order.OrderService;
import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.Service.Product.Impl.ProductServiceImpl;
import com.EasyBuy.entity.Cart;
import com.EasyBuy.entity.CartItem;
import com.EasyBuy.entity.Order;
import com.EasyBuy.entity.OrderDetail;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.User;
import com.EasyBuy.util.StringUtil;


public class OrderServiceImpl implements OrderService{
	
	OrderDao orderDao=new OrderDaoImpl();
	OrderDetailService orderDetailService=new OrderDetailServiceImpl();
	ProductService productService=new ProductServiceImpl();
	/**
	 * 分页查询订单
	 * @param con
	 * @param pageBean
	 * @return
	 */
	public List<Order> list(Connection con,PageBean pageBean,Integer userId){
		return orderDao.list(con, pageBean,userId);
		
	}
	
	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con,Integer userId) {
		return orderDao.getCount(con,userId);
		
	}
	
	/**
	 * 订单id查询该订单详情
	 * @param con
	 * @param orderId
	 * @return
	 */
	public List<OrderDetail> queryOrderDetail(Connection con,Integer orderId){
		return orderDao.queryOrderDetail(con, orderId);
		
	}
	
	/**
	 * 添加订单
	 * @param con
	 * @param cart
	 * @param user
	 * @param address
	 * @return
	 */
	public Order insert(Connection con,Cart cart,User user,String address) {
		Order order = new Order();
		order.setUserId(user.getId());
		order.setLoginName(user.getLoginName());
		order.setUserAddress(address);
		order.setCost(cart.getTotalMoney());
		order.setSerialNumber(StringUtil.randomUUID());
		orderDao.insert(con, order);
		
		//添加订单详情
		for(CartItem item : cart.getCartItems()) {
			OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());//订单id
            orderDetail.setProductId(item.getProduct().getId());//商品id
            orderDetail.setQuantity(item.getGoNum());//
            orderDetail.setCost(item.getCost());
            orderDetailService.add(con,orderDetail);
            
          //更新商品表的库存
            productService.updateStock(con,item.getProduct().getId(), (item.getProduct().getStock()-item.getGoNum()));
		}
		return order;
	}

}
