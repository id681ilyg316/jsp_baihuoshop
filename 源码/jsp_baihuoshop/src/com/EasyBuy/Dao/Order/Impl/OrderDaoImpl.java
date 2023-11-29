package com.EasyBuy.Dao.Order.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyBuy.Dao.BaseDao;
import com.EasyBuy.Dao.Order.OrderDao;
import com.EasyBuy.entity.Cart;
import com.EasyBuy.entity.Order;
import com.EasyBuy.entity.OrderDetail;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.User;
import com.EasyBuy.util.StringUtil;

/**
 * 订单Dao接口实现
 * @author Administrator
 *
 */
public class OrderDaoImpl extends BaseDao implements OrderDao{

	private ResultSet rs=null;
	
	/**
	 * 分页查询订单
	 * @param con
	 * @param pageBean
	 * @return
	 */
	@Override
	public List<Order> list(Connection con, PageBean pageBean,Integer userId) {
		StringBuffer  sb=new StringBuffer("select * from easybuy_order ");
		if(userId!=null) {
			sb.append(" where userId="+userId);
		}
		List<Order> orderList=new ArrayList<>();
		sb.append(" order by createTime desc");
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		Order order=null;
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				order=new Order();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setLoginName(rs.getString("loginName"));
				order.setUserAddress(rs.getString("userAddress"));
				order.setCreateTime(rs.getDate("createTime"));
				order.setCost(rs.getDouble("cost"));
				order.setSerialNumber(rs.getString("serialNumber"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	
	/**
	 * 查询订单总记录数
	 * @param con
	 * @return
	 */
	@Override
	public int getCount(Connection con,Integer userId) {
		StringBuffer sb=new StringBuffer("select count(*) as total from easybuy_order ");
		
		if(userId!=null) {
			sb.append(" where userId="+userId);
		}
		int total=0;
		try {
			rs=executeQuery(con,sb.toString(),null);
			if(rs.next()) {
				total=rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	/**
	 * 订单id查询该订单详情
	 * @param con
	 * @param orderId
	 * @return
	 */
	@Override
	public List<OrderDetail> queryOrderDetail(Connection con, Integer orderId) {
		StringBuffer sb=new StringBuffer("select * from easybuy_order_detail where orderId="+orderId);
		List<OrderDetail> orderDetailList=new ArrayList<>();
		try {
			rs=executeQuery(con,sb.toString(),null);
			OrderDetail orderDetail=null;
			while(rs.next()) {
				orderDetail=new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrderId(rs.getInt("orderId"));
				orderDetail.setProductId(rs.getInt("productId"));
				orderDetail.setQuantity(rs.getInt("quantity"));
				orderDetail.setCost(rs.getDouble("cost"));
				orderDetailList.add(orderDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderDetailList;
	}

	/**
	 * 添加订单 
	 */
	@Override
	public void insert(Connection con, Order order) {
		String sql="insert into easybuy_order values(null,?,?,?,now(),?,?)";
		Object [] params= {
				order.getUserId(),
				order.getLoginName(),
				order.getUserAddress(),
				order.getCost(),
				order.getSerialNumber()
		};
		int id=executeInsert(con, sql, params);//返回订单id
		order.setId(id);
		
	}

}
