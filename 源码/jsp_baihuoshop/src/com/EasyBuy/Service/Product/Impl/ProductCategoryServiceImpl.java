package com.EasyBuy.Service.Product.Impl;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.Dao.Product.ProductCategoryDao;
import com.EasyBuy.Dao.Product.Impl.ProductCategoryDaoImpl;
import com.EasyBuy.Service.Product.ProductCategoryService;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.ProductCategory;

/**
 * 商品分类Service接口实现
 * @author Administrator
 *
 */
public class ProductCategoryServiceImpl implements ProductCategoryService{

	ProductCategoryDao productCategoryDao=new ProductCategoryDaoImpl();
	
	/**
	 * 查询商品一级类别
	 * @return
	 */
	@Override
	public List<ProductCategory> Categorylist(Connection con,Integer type) {
		// TODO Auto-generated method stub
		return productCategoryDao.Categorylist(con,type);
	}

	/**
	 * 查询商品所有类别
	 * @param con
	 * @return
	 */
	public List<ProductCategory> list(Connection con,PageBean pageBean){
		return productCategoryDao.list(con,pageBean);
		
	}
	
	/**
	 * 查询商品类别总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con) {
		return productCategoryDao.getCount(con);
	}
	
	/**
	 * 查询商品2 ~3级分类
	 * @param con
	 * @param type
	 * @param parentId
	 * @return
	 */
	public List<ProductCategory> childCategorylist(Connection con,Integer type,Integer parentId){
		return productCategoryDao.childCategorylist(con, type, parentId);
		
	}
	
	
	
	/**
	 * 添加商品分类
	 * @param con
	 * @param sql
	 * @param parentId
	 * @param type
	 * @return
	 */
	public int insert(Connection con,String name,Integer parentId,Integer type) {
		return productCategoryDao.insert(con,name, parentId, type);
	}
	
	/**
	 * 修改商品分类
	 * @param con
	 * @param sql
	 * @param parentId
	 * @param type
	 * @return
	 */
	public int update(Connection con,String name,Integer parentId,Integer type,Integer id) {
		return productCategoryDao.update(con, name, parentId, type, id);
		
	}
	
	/**
	 * 删除商品分类
	 * @param con
	 * @param id
	 * @return
	 */
	public int deleteProductCategory(Connection con,Integer id) {
		return productCategoryDao.deleteProductCategory(con, id);
		
	}
	
	/**
	 * 通过id查询对应商品类别
	 * @return
	 */
	public ProductCategory findByid(Connection con,Integer id) {
		return productCategoryDao.findByid(con, id);
		
	}
	
	/**
	 * 查询父级类别
	 * @param con
	 * @param parentId
	 * @return
	 */
	public ProductCategory findParentCategory(Connection con,Integer parentId) {
		return productCategoryDao.findParentCategory(con,parentId);
		
	}

}
