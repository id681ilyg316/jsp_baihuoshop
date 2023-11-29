package com.EasyBuy.web.backend;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.EasyBuy.Service.Product.ProductCategoryService;
import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.Service.Product.Impl.ProductCategoryServiceImpl;
import com.EasyBuy.Service.Product.Impl.ProductServiceImpl;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;
import com.EasyBuy.entity.ProductCategory;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.PageUtil;
import com.EasyBuy.util.PropertiesUtil;
import com.EasyBuy.util.ResponseUtil;
import com.EasyBuy.util.StringUtil;
import com.EasyBuy.util.DateUtil;

import net.sf.json.JSONObject;


@WebServlet(urlPatterns = {"/admin/product"},name = "adminProduct")
public class AdminProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	ProductService productService=new ProductServiceImpl();
	ProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if("index".equals(action)) {
			this.ProductList(request,response);
		}else if("deleteById".equals(action)) {
			this.deleteProduct(request,response);
		}else if("preSave".equals(action)) {
			this.PreSave(request,response);
		}else if("save".equals(action)) {
			try {
				this.save(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 添加商品
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=null;
		try {
			items=upload.parseRequest(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator itr=items.iterator();
		Product product=new Product();
		while(itr.hasNext()){
			FileItem item=(FileItem) itr.next();
			if(item.isFormField()){
				String fieldName=item.getFieldName();
				if("categoryLevel1Id".equals(fieldName)) {
					if(StringUtil.isNotEmpty(item.getString("utf-8"))) {
						product.setCategoryLevel1Id(Integer.parseInt(item.getString("utf-8")));
					}
				}
				if("categoryLevel2Id".equals(fieldName)) {
					if(StringUtil.isNotEmpty(item.getString("utf-8"))) {
						product.setCategoryLevel2Id(Integer.parseInt(item.getString("utf-8")));
					}
				}
				
				if("categoryLevel3Id".equals(fieldName)) {
					if(StringUtil.isNotEmpty(item.getString("utf-8"))) {
						product.setCategoryLevel3Id(Integer.parseInt(item.getString("utf-8")));
					}
				}
				
				if("id".equals(fieldName)) {
					if(StringUtil.isNotEmpty(item.getString("utf-8"))) {
						product.setId(Integer.parseInt(item.getString("utf-8")) );
					}
				}
				
				if("name".equals(fieldName)){
					product.setName(item.getString("utf-8")); 
				}
				if("price".equals(fieldName)){
					product.setPrice(Double.parseDouble(item.getString("utf-8")));
				}
				if("stock".equals(fieldName)){
					product.setStock(Integer.parseInt(item.getString("utf-8")));
				}if("description".equals(fieldName)){
					product.setDescription(item.getString("utf-8")); 
				}
				
				if("imageName".equals(fieldName)&& product.getFileName()==null) {
					if(StringUtil.isNotEmpty(item.getString("utf-8"))) {
						product.setFileName(item.getString("utf-8"));
					}
				}
				
			}else if(!"".equals(item.getName())){
				try {
					String fileName=item.getName();//获取文件名称
					String suffixName= fileName.substring(fileName.lastIndexOf(".")) ;//获取后缀名（.jpg 或者其他后缀名）
					String newFileName=DateUtil.getCurrentDateStr()+suffixName;//获取新文件名称
					product.setFileName(newFileName);
					String filePath="D:\\LHJDM\\baihuoshop\\WebContent\\files\\"+newFileName;
					//FileUtils.copyInputStreamToFile(item.getInputStream(), new File(filePath));
					item.write(new File(filePath));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			
			if(product.getId()==null) {
				productService.add(con, product);
			}else {
				productService.update(con, product);
			}
			request.getRequestDispatcher("/admin/product?action=index").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 *  添加商品  修改商品跳转
	 * @param request
	 * @param response
	 */
	public void PreSave(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			request.setAttribute("menu", 6);
			List<ProductCategory> productCategoryList1= productCategoryService.Categorylist(con,1);//查询所有一级类别
			List<ProductCategory> productCategoryList2=productCategoryService.Categorylist(con, 2);//查询所有二级类别
			List<ProductCategory> productCategoryList3=productCategoryService.Categorylist(con, 3);//查询所有三级类别
			request.setAttribute("productCategoryList1", productCategoryList1);
			if(StringUtil.isNotEmpty(id)) {
				//商品修改
				Product product=productService.findById(con, Integer.parseInt(id));//商品id查询商品信息
				request.setAttribute("product", product);
				request.setAttribute("productCategoryList2", productCategoryList2);
				request.setAttribute("productCategoryList3", productCategoryList3);
				request.setAttribute("mainPage", "product/toAddProduct.jsp");
			}else {
				//商品添加
				request.setAttribute("mainPage", "product/toAddProduct.jsp");
			}
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除商品
	 * @param request
	 * @param response
	 */
	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String id=request.getParameter("id");
		try {
			con=dbUtil.getCon();
			int index=productService.delete(con, Integer.parseInt(id));
			JSONObject jsonStr=new JSONObject();
			if(index!=0) {
				jsonStr.put("status", 1);
			}else {
				jsonStr.put("status", 0);
			}
			ResponseUtil.write(jsonStr, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查询商品
	 * @param request
	 * @param response
	 */
	private void ProductList(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String page=request.getParameter("page");
		
		try {
			con=dbUtil.getCon();
			int total=productService.getCount(con,null,null,null);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("pageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("pageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("pageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			List<Product> productList=productService.list(con,pageBean,null);
			request.setAttribute("menu", 5);
			request.setAttribute("productList", productList);
			request.setAttribute("pageCode", PageUtil.getPagation("product?action=index",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			request.setAttribute("mainPage", "product/productList.jsp");
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
