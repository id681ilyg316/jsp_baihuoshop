package com.EasyBuy.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyBuy.Service.Order.OrderService;
import com.EasyBuy.Service.Order.Impl.OrderServiceImpl;
import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.Service.Product.Impl.ProductServiceImpl;
import com.EasyBuy.entity.Order;
import com.EasyBuy.entity.OrderDetail;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.PageUtil;
import com.EasyBuy.util.PropertiesUtil;
import com.EasyBuy.util.StringUtil;

@WebServlet(urlPatterns = {"/admin/order"})
public class AdminOrderServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbutil=new DbUtil();
	OrderService orderService=new OrderServiceImpl();
	ProductService productService=new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if("queryAllOrder".equals(action)) {
			this.queryAllOrder(request,response);
		}else if("queryMyOrder".equals(action)) {
			this.queryMyOrder(request,response);
		}
	}

	/**
	 * 查询我的订单
	 * @param request
	 * @param response
	 */
	private void queryMyOrder(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String page=request.getParameter("page");
		String userId=request.getParameter("userId");
		List<Map<String,Object>> orderMapList=new ArrayList<>();
		try {
			con=dbutil.getCon();
			
			if(StringUtil.isEmpty(userId)) {
				request.getRequestDispatcher("/Pre/login.jsp").forward(request, response);
			}else {
				
				int total=orderService.getCount(con,Integer.parseInt(userId));
				int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("pageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("pageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("pageSize")))+1;//总页数
				if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
					page="1";
				}
				PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
				
				//查询我的订单
				List<Order> orderList=orderService.list(con, pageBean, Integer.parseInt(userId));
				Map<String,Object> map=null;
				for(int i=0;i<orderList.size();i++) {
					map=new HashMap<>();
					map.put("order", orderList.get(i));
					//查询订单详情
					List<OrderDetail> orderDetailList=orderService.queryOrderDetail(con, orderList.get(i).getId());
					List<Product> productList=new ArrayList<>();
					for(int j=0;j<orderDetailList.size();j++) {
						Product product=productService.findById(con, orderDetailList.get(j).getProductId());
						product.setQuantity(orderDetailList.get(j).getQuantity());
						productList.add(product);
					}
					map.put("productList", productList);
					orderMapList.add(map);
				}
				request.setAttribute("menu", 1);
				request.setAttribute("orderMapList", orderMapList);
				request.setAttribute("pageCode", PageUtil.getPagation("order?action=queryMyOrder&userId="+userId+"",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
				request.setAttribute("mainPage", "order/orderList.jsp");
				request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
			}
			
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			dbutil.closeCon(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	/**
	 * 查询全部订单
	 * @param request
	 * @param response
	 */
	public void queryAllOrder(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String page=request.getParameter("page");
		List<Map<String,Object>> orderMapList=new ArrayList<>();
		try {
			con=dbutil.getCon();
			int total=orderService.getCount(con,null);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("pageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("pageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("pageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			
				//查询全部订单
				List<Order> orderList=orderService.list(con, pageBean, null);
				Map<String,Object> map=null;
				for(int i=0;i<orderList.size();i++) {
					map=new HashMap<>();
					map.put("order", orderList.get(i));
					//查询订单详情
					List<OrderDetail> orderDetailList=orderService.queryOrderDetail(con, orderList.get(i).getId());
					List<Product> productList=new ArrayList<>();
					for(int j=0;j<orderDetailList.size();j++) {
						Product product=productService.findById(con, orderDetailList.get(j).getProductId());
						product.setQuantity(orderDetailList.get(j).getQuantity());
						productList.add(product);
					}
					map.put("productList", productList);
					orderMapList.add(map);
				}
				
			request.setAttribute("menu", 3);
			request.setAttribute("orderMapList", orderMapList);
			request.setAttribute("pageCode", PageUtil.getPagation("order?action=queryAllOrder",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			request.setAttribute("mainPage", "order/orderList.jsp");
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
