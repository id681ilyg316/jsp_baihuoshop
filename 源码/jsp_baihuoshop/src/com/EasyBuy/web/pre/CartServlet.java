package com.EasyBuy.web.pre;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyBuy.Service.Order.OrderService;
import com.EasyBuy.Service.Order.Impl.OrderServiceImpl;
import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.Service.Product.Impl.ProductServiceImpl;
import com.EasyBuy.Service.User.UserAddressService;
import com.EasyBuy.Service.User.Impl.UserAddressServiceImpl;
import com.EasyBuy.entity.Cart;
import com.EasyBuy.entity.Order;
import com.EasyBuy.entity.Product;
import com.EasyBuy.entity.User;
import com.EasyBuy.entity.UserAddress;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.ResponseUtil;

import net.sf.json.JSONObject;



/**
 * 购物车控制器
 * @author Administrator
 *
 */
@WebServlet(urlPatterns="/cart")
public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbutil=new DbUtil();
	ProductService productService=new ProductServiceImpl();
	UserAddressService userAddressService=new UserAddressServiceImpl();
	OrderService orderService=new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		 this.doPost(req, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //用于判断是什么功能
		String action=request.getParameter("action")==null?"list":request.getParameter("action");
	    if("addCart".equals(action)) {//添加购物车的方法
	    	addCart(request,response);
	    }else if("refCart".equals(action)) { //刷新购物，获取购物车
	    	refCart(request,response);
	    }else if("toSettlement".equals(action)) {
	    	this.toSettlement(request,response);//结算
	    }else if("modCart".equals(action)) {
	    	this.modCart(request,response);// 修改购物车列表
	    }else if("settlement1".equals(action)) {
	    	this.settlement1(request,response);
	    }else if("delete".equals(action)) {
	    	this.delete(request,response);
	    }else if("settlement2".equals(action)) {
	    	this.settlement2(request,response);
	    }else if("settlement3".equals(action)) {
	    	this.settlement3(request,response);
	    }
	}

	/**
	 * 结算 订单支付提醒
	 * @param request
	 * @param response
	 */
	public void settlement3(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String newAddress=request.getParameter("newAddress");
		String newRemark=request.getParameter("newRemark");
		String addressId=request.getParameter("addressId");
		User currentUser=(User) request.getSession().getAttribute("currentUser");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		try {
			con=dbutil.getCon();
			UserAddress userAddress=new UserAddress();
			if("-1".equals(addressId)) {
				userAddress.setUserId(currentUser.getId());
				userAddress.setAddress(newAddress);
				userAddress.setRemark(newRemark);
				userAddress.setId(userAddressService.insert(con, userAddress));
			}else {
				userAddress=userAddressService.findById(con, Integer.parseInt(addressId));
			}
			
			//添加订单
			 Order order=orderService.insert(con, cart, currentUser, userAddress.getAddress());
			 clearCart(request, response);
		     request.setAttribute("currentOrder", order);
		     request.getRequestDispatcher("/Pre/settlement/settlement3.jsp").forward(request, response);
			
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
	
	/**
     * 清空购物车
     *
     * @param request
     * @param response
     */
    public void clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //结账后清空购物车
        request.getSession().removeAttribute("cart");
    }

	/**
	 * 结算 加载购物车列表
	 * @param request
	 * @param response
	 */
	public void settlement1(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/Pre/settlement/settlement1.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * 结算 形成预备订单
	 * @param request
	 * @param response
	 */
	public void settlement2(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		
		try {
			con=dbutil.getCon();
			List<UserAddress> userAddressList= userAddressService.list(con);
			request.setAttribute("userAddressList", userAddressList);
			request.getRequestDispatcher("/Pre/settlement/settlement2.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * 删除
	 * @param request
	 * @param response
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String entityId=request.getParameter("entityId");//商品id
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		JSONObject result=new JSONObject();
		double rental=0D;
		for(int i=0;i<cart.getCartItems().size();i++) {
			if(Integer.parseInt(entityId)==cart.getCartItems().get(i).getProduct().getId()) {
				cart.getCartItems().remove(i);
				//更新订单总金额
				for(int j=0;j<cart.getCartItems().size();j++) {
					int goNum=cart.getCartItems().get(j).getGoNum();//商品购买数量
					double price=cart.getCartItems().get(j).getProduct().getPrice();//商品价格
					rental+=goNum*price;
				}
				cart.setTotalMoney(rental);//设置新的订单总金额
				result.put("success", true);
			}
		}
		try {
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 修改购物车列表
	 * @param request
	 * @param response
	 */
	public void modCart(HttpServletRequest request, HttpServletResponse response) {
		String entityId=request.getParameter("entityId");//商品id
		String quantity=request.getParameter("quantity");//添加数量
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		JSONObject result=new JSONObject();
		double rental=0D;
		for(int i=0;i<cart.getCartItems().size();i++) {
			if(Integer.parseInt(entityId)==cart.getCartItems().get(i).getProduct().getId()) {
				cart.getCartItems().get(i).setGoNum(Integer.parseInt(quantity));//设置商品新的数量
				cart.getCartItems().get(i).setCost(cart.getCartItems().get(i).getProduct().getPrice()*Integer.parseInt(quantity));//更新该商品的总金额
				
				//更新订单总金额
				for(int j=0;j<cart.getCartItems().size();j++) {
					int goNum=cart.getCartItems().get(j).getGoNum();//商品购买数量
					double price=cart.getCartItems().get(j).getProduct().getPrice();//商品价格
					rental+=goNum*price;
				}
				cart.setTotalMoney(rental);//设置新的订单总金额
				result.put("success", true);
			}
		}
		try {
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 去结算
	 * @param request
	 * @param response
	 */
	public void toSettlement(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setAttribute("mainPage", "settlement1.jsp");
			request.getRequestDispatcher("/Pre/settlement/toSettlement.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 重新获取购物车信息
	 * @param request
	 * @param response
	 */
	private void refCart(HttpServletRequest request, HttpServletResponse response) {
		try {
			//因为购物车的数据存放在session中，所有不需要在servlet中获取session数据。
			request.getRequestDispatcher("/common/pre/cart.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * 添加购物车的方法
	 * @param request
	 * @param response
	 */
	private void addCart(HttpServletRequest request, HttpServletResponse response) {
		Cart cart=(Cart)request.getSession().getAttribute("cart");//获取购物车对象
		String id=request.getParameter("id");//获取商品编号
		String num=request.getParameter("num");//添加数量
		Connection con=null;
		JSONObject result=new JSONObject();
		Integer total=null;
		if(cart==null) { //第一次添加购物车
			cart=new Cart();
		}
		try {
			con=dbutil.getCon();
			Product product=productService.findById(con, Integer.parseInt(id));//查询商品信息
			if(cart.getCartItems().size()<=0) {
				total=Integer.parseInt(num);
			}else {
				for(int i=0;i<cart.getCartItems().size();i++) {
					if(Integer.parseInt(id)==cart.getCartItems().get(i).getProduct().getId()) {
						total=Integer.parseInt(num)+cart.getCartItems().get(i).getGoNum();
						break;
					}else {
						total=Integer.parseInt(num);
					}
				}
			}
			if(product.getStock()<total) {
				result.put("success", false);
			}else {
				cart.addCart(product,num);
				double rental=0D;
				for(int i=0;i<cart.getCartItems().size();i++) {
					int goNum=cart.getCartItems().get(i).getGoNum();//商品购买数量
					double price=cart.getCartItems().get(i).getProduct().getPrice();//商品价格
					rental+=goNum*price;
				}
				cart.setTotalMoney(rental);//总金额
				request.getSession().setAttribute("cart", cart);
				result.put("success", true);
			}
			ResponseUtil.write(result, response);
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
