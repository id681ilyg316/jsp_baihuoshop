package com.EasyBuy.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyBuy.Service.Product.ProductCategoryService;
import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.Service.Product.Impl.ProductCategoryServiceImpl;
import com.EasyBuy.Service.Product.Impl.ProductServiceImpl;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.ProductCategory;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.PageUtil;
import com.EasyBuy.util.PropertiesUtil;
import com.EasyBuy.util.ResponseUtil;
import com.EasyBuy.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet(urlPatterns = {"/admin/productCategory"},name = "adminProductCategory")
public class AdminProductCategoryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if("queryProductCategoryList".equals(action)) {
			this.childCategoryList(request, response);
		}else if("CategoryList".equals(action)) {
			this.CategoryList(request, response);
		}else if("presave".equals(action)) {
			this.Presave(request, response);
		}else if("save".equals(action)) {
			this.saveProductCategory(request, response);
		}else if("deleteProductCategory".equals(action)) {
			this.deleteProductCategory(request, response);
		}
	}

	/**
	 * 保存商品类别
	 * @param request
	 * @param response
	 */
	public void saveProductCategory(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String productCategoryLevel1=request.getParameter("productCategoryLevel1");//获取一级分类
		String productCategoryLevel2=request.getParameter("productCategoryLevel2");//获取二级分类
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			JSONObject jsonStr=new JSONObject();
			if(StringUtil.isNotEmpty(id)) {
				//修改商品类别
				if(Integer.parseInt(type)!=3) {
					//修改一级或二级类别
					int index=productCategoryService.update(con, name,Integer.parseInt(productCategoryLevel1), Integer.parseInt(type),Integer.parseInt(id));
					if(index>0) {
						jsonStr.put("status", 1);
					}
				}else {
					//修改三级类别
					int index=productCategoryService.update(con, name,Integer.parseInt(productCategoryLevel2), Integer.parseInt(type),Integer.parseInt(id));
					if(index>0) {
						jsonStr.put("status", 1);
					}
				}
			}else {
				//添加商品类别
				if(Integer.parseInt(type)!=3) {
					//添加一级或二级类别
					int index=productCategoryService.insert(con, name,Integer.parseInt(productCategoryLevel1), Integer.parseInt(type));
					if(index>0) {
						jsonStr.put("status", 1);
					}
				}else{
					//添加三级类别
					int index=productCategoryService.insert(con, name,Integer.parseInt(productCategoryLevel2), Integer.parseInt(type));
					if(index>0) {
						jsonStr.put("status", 1);
					}
				}
			}
			ResponseUtil.write(jsonStr, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * 删除商品类别
	 * @param request
	 * @param response
	 */
	public void deleteProductCategory(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String id=request.getParameter("id");
		try {
			con=dbUtil.getCon();
			int index=productCategoryService.deleteProductCategory(con, Integer.parseInt(id));
			JSONObject jsonStr=new JSONObject();
			if(index>0) {
				jsonStr.put("status", 1);
			}else {
				jsonStr.put("message", "删除失败");
			}
			ResponseUtil.write(jsonStr, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 添加 和 修改商品分类跳转
	 * @param request
	 * @param response
	 */
	public void Presave(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			if(StringUtil.isEmpty(id)) {
				//添加商品分类
				//查询一级分类 全部
				List<ProductCategory> productCategoryList=productCategoryService.Categorylist(con,1);
				request.setAttribute("productCategoryList1",productCategoryList);
			}else {
				//修改商品类别
				//查询一级分类 全部
				List<ProductCategory> productCategoryList=productCategoryService.Categorylist(con,1);
				request.setAttribute("productCategoryList1",productCategoryList);
				
				//查询全部二级分类
				List<ProductCategory> productCategoryList2=productCategoryService.Categorylist(con, 2);
				request.setAttribute("productCategoryList2",productCategoryList2);
				
				//查询修改的实体
				ProductCategory productCategory=productCategoryService.findByid(con, Integer.parseInt(id));
				ProductCategory parentProductCategory=null;
				if(productCategory.getType()==3) {
					parentProductCategory=productCategoryService.findParentCategory(con, productCategoryService.findParentCategory(con, productCategory.getParentId()).getParentId());
				}
				request.setAttribute("parentProductCategory", parentProductCategory);
				request.setAttribute("productCategory", productCategory);
			}
			request.setAttribute("mainPage", "productCategory/toAddProductCategory.jsp");
	        request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 分类管理显示所有商品分类
	 * @param request
	 * @param response
	 */
	public void CategoryList(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String page=request.getParameter("page");
		try {
			con=dbUtil.getCon();
			int total=productCategoryService.getCount(con);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("pageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("pageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("pageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			List<ProductCategory> allCategoryList=productCategoryService.list(con,pageBean);
			for(int i=0;i<allCategoryList.size();i++) {
				Integer parentId=allCategoryList.get(i).getParentId();
				if(parentId>0) {
					ProductCategory productCategory=productCategoryService.findParentCategory(con, parentId);//！
					allCategoryList.get(i).setParentName(productCategory.getName());
				}
			}
			request.setAttribute("pageCode", PageUtil.getPagation("productCategory?action=CategoryList",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			request.setAttribute("allCategoryList", allCategoryList);
			request.setAttribute("menu", 4);
			request.setAttribute("mainPage", "productCategory/productCategoryList.jsp");
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询下级类别
	 * @param request
	 * @param response
	 */
	public void childCategoryList(HttpServletRequest request, HttpServletResponse response) {
		String parentId=request.getParameter("parentId");
		String type=request.getParameter("type");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			List<ProductCategory> childCategoryList=productCategoryService.childCategorylist(con, Integer.parseInt(type), Integer.parseInt(parentId));
			JSONObject result=new JSONObject();
			if(childCategoryList!=null) {
				result.put("status", 1);
				result.put("childCategoryList", childCategoryList);
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
