package com.EasyBuy.web.pre;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.Service.Product.Impl.ProductServiceImpl;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.PageUtil;
import com.EasyBuy.util.PropertiesUtil;
import com.EasyBuy.util.StringUtil;

@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbutil=new DbUtil();
	ProductService productService=new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if("productList".equals(action)) {
			this.productList(request,response);
		}else if("productList2".equals(action)) {
			this.productList2(request,response);
		}else if("productList3".equals(action)) {
			this.productList3(request,response);
		}else if("queryProductDeatil".equals(action)) {
			this.productDetail(request,response);
		}else if("dimProductName".equals(action)) {
			this.dimProductName(request,response);
		}
	}
	
	/**
	 * 模糊查询
	 * @param request
	 * @param response
	 */
	private void dimProductName(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String keyWord=request.getParameter("keyWord");
		String page=request.getParameter("page");
		try {
			con=dbutil.getCon();
			int total=productService.getCount(con,null,null,keyWord);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("prepageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("prepageSize")));
			List<Product> productList=productService.list(con,pageBean,keyWord);
			request.setAttribute("total", total);
			request.setAttribute("keyWord", keyWord);
			request.setAttribute("productList", productList);
			request.setAttribute("pageCode", PageUtil.getPagation("product?action=dimProductName",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			request.getRequestDispatcher("/Pre/product/queryProductList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 商品详情
	 * @param request
	 * @param response
	 */
	public void productDetail(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String id=request.getParameter("id");
		try {
			con=dbutil.getCon();
			Product product=productService.findById(con, Integer.parseInt(id));
			request.setAttribute("product", product);
			request.getRequestDispatcher("/Pre/product/productDeatil.jsp").forward(request, response);
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
	 * 查询三级类别下的商品
	 * @param request
	 * @param response
	 */
	public void productList3(HttpServletRequest request, HttpServletResponse response) {
		String type="3";
		String id=request.getParameter("id");//商品类别id
		Connection con=null;
		String page=request.getParameter("page");
		try {
			con=dbutil.getCon();
			int total=productService.getCount(con,Integer.parseInt(id),type,null);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("prepageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("prepageSize")));
			List<Product> productList=productService.findByCategoryLevel3Id(con, Integer.parseInt(id),pageBean);
			request.setAttribute("total", total);
			request.setAttribute("productList", productList);
			request.setAttribute("pageCode", PageUtil.getPagation("product?action=productList3",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("prepageSize")))); 
			request.getRequestDispatcher("/Pre/product/queryProductList.jsp").forward(request, response);
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
	 * 查询二级类别下的商品
	 * @param request
	 * @param response
	 */
	public void productList2(HttpServletRequest request, HttpServletResponse response) {
		String type="2";
		String id=request.getParameter("id");//商品类别id
		Connection con=null;
		String page=request.getParameter("page");
		try {
			con=dbutil.getCon();
			int total=productService.getCount(con,Integer.parseInt(id),type,null);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("prepageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("prepageSize")));
			List<Product> productList=productService.findByCategoryLevel2Id(con, Integer.parseInt(id),pageBean);
			request.setAttribute("total", total);
			request.setAttribute("productList", productList);
			request.setAttribute("pageCode", PageUtil.getPagation("product?action=productList2",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("prepageSize")))); 
			request.getRequestDispatcher("/Pre/product/queryProductList.jsp").forward(request, response);
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
	 * 查询一级类别下的商品
	 * @param request
	 * @param response
	 */
	public void productList(HttpServletRequest request, HttpServletResponse response) {
		String type="1";
		String id=request.getParameter("id");//商品类别id
		Connection con=null;
		String page=request.getParameter("page");
		try {
			con=dbutil.getCon();
			int total=productService.getCount(con,Integer.parseInt(id),type,null);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("prepageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("prepageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("prepageSize")));
			List<Product> productList=productService.findByCategoryLevel1Id(con, Integer.parseInt(id),pageBean);
			request.setAttribute("total", total);
			request.setAttribute("productList", productList);
			request.setAttribute("pageCode", PageUtil.getPagation("product?action=productList",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("prepageSize")))); 
			request.getRequestDispatcher("/Pre/product/queryProductList.jsp").forward(request, response);
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
