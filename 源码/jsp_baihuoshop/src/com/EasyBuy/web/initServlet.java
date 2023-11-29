package com.EasyBuy.web;

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
import javax.servlet.http.HttpSession;

import com.EasyBuy.Service.News.NewsService;
import com.EasyBuy.Service.News.Impl.NewsServiceImpl;
import com.EasyBuy.Service.Product.ProductCategoryService;
import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.Service.Product.Impl.ProductCategoryServiceImpl;
import com.EasyBuy.Service.Product.Impl.ProductServiceImpl;
import com.EasyBuy.entity.News;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;
import com.EasyBuy.entity.ProductCategory;
import com.EasyBuy.util.DbUtil;

@WebServlet(urlPatterns = {"/init"})
public class initServlet extends HttpServlet{

	/**
	 * 更多资源关注微信公众号：毕业程序员
	 */
	private static final long serialVersionUID = 1L;

	DbUtil dbutil=new DbUtil();
	ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
	ProductService productService=new ProductServiceImpl();
	NewsService newsService=new NewsServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		HttpSession session=request.getSession();
		try {
			con=dbutil.getCon();
			
			//前台商品类别查询
			List<Map<String,Object>> productCategoryVoList1=new ArrayList<>();
			List<ProductCategory> pc1=productCategoryService.Categorylist(con, 1);//查询所有一级类别
			for(int i=0;i<pc1.size();i++) {
				Map<String,Object> map1=new HashMap<>();
				map1.put("productCategory", pc1.get(i));//存入一级类别对象
				List<Map<String,Object>> productCategoryVoList2=new ArrayList<>();
				map1.put("productCategoryVoList2", productCategoryVoList2);//存入包含二级类别的集合
				//查询一级类别下的所有二级类别
				List<ProductCategory> pc2=productCategoryService.childCategorylist(con, 2, pc1.get(i).getId());
				for(int j=0;j<pc2.size();j++) {
					Map<String,Object> map2=new HashMap<>();
					map2.put("productCategory", pc2.get(j));//存入二级类别对象
					//查询二级类别下的三级类别商品集合存入map2中
					map2.put("productCategoryVoList3", productCategoryService.childCategorylist(con, 3, pc2.get(j).getId()));
					productCategoryVoList2.add(map2);
				}
				productCategoryVoList1.add(map1);
			}
			
			
			//前台商品查询
			List<ProductCategory> productCategoryList=productCategoryService.Categorylist(con, 1);//查询出所有一级商品类别集合
			List<Map<String,Object>> mapProductList=new ArrayList<>();
			//便利一级商品类别集合,查询出该类别下商品
			for(int i=0;i<productCategoryList.size();i++) {
				Map<String,Object> map=new HashMap<>();
				map.put("productCategory", productCategoryList.get(i));
				List<Product> productList=productService.findByCategoryLevel1Id(con, productCategoryList.get(i).getId(),new PageBean(1, 6));//查询一级类别下的商品集合
				map.put("productList", productList);
				List<ProductCategory> productCategoryListTwo=productCategoryService.childCategorylist(con, 2, productCategoryList.get(i).getId());//查询一级类别下的二级类别集合
				map.put("productCategoryListTwo", productCategoryListTwo);
				mapProductList.add(map);
			}

			//查询资讯
			List<News> newsList=newsService.list(con, new PageBean(1, 5));
			
			request.setAttribute("newsList", newsList);//前台资讯
			session.setAttribute("productCategoryList", productCategoryList);//前台商品一级类别
			request.setAttribute("mapProductList", mapProductList);//前台商品
			session.setAttribute("productCategoryVoList1", productCategoryVoList1);//前台商品类别列表
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
