package com.EasyBuy.Dao.Product;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.ProductCategory;

/**
 * 商品分类Dao接口
 * @author Administrator
 *
 */
public interface ProductCategoryDao {
	
	/**
	 * 查询商品类别
	 * @return
	 */
	public List<ProductCategory> Categorylist(Connection con,Integer type);
	
	/**
	 * 添加商品分类
	 * @param con
	 * @param sql
	 * @param parentId
	 * @param type
	 * @return
	 */
	public int insert(Connection con,String name,Integer parentId,Integer type);
	
	/**
	 * 修改商品分类
	 * @param con
	 * @param sql
	 * @param parentId
	 * @param type
	 * @return
	 */
	public int update(Connection con,String name,Integer parentId,Integer type,Integer id);
	
	/**
	 * 查询商品所有类别
	 * @param con
	 * @return
	 */
	public List<ProductCategory> list(Connection con,PageBean pageBean);
	
	/**
	 * 查询商品类别总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con);
	
	/**
	 * 查询商品2 ~ 3级分类
	 * @param con
	 * @param type
	 * @param parentId
	 * @return
	 */
	public List<ProductCategory> childCategorylist(Connection con,Integer type,Integer parentId);
	
	
	
	/**
	 * 删除商品分类
	 * @param con
	 * @param id
	 * @return
	 */
	public int deleteProductCategory(Connection con,Integer id);
	
	/**
	 * 通过id查询对应商品类别
	 * @return
	 */
	public ProductCategory findByid(Connection con,Integer id);
	
	/**
	 * 查询父级类别
	 * @param con
	 * @param parentId
	 * @return
	 */
	public ProductCategory findParentCategory(Connection con,Integer parentId);
}
