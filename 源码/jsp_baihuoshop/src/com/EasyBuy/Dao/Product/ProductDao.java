package com.EasyBuy.Dao.Product;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;

/**
 * 商品Dao接口
 * @author Administrator
 *
 */
public interface ProductDao {
	
	/**
	 * 商品查询
	 * @return
	 */
	public List<Product> list(Connection con,PageBean pageBean,String keyWord);
	
	/**
	 * 查询商品一级类别id下的商品
	 */
	public List<Product> findByCategoryLevel1Id(Connection con,Integer categoryLevel1Id,PageBean pageBean);
	
	
	
	/**
	 * 查询商品二级类别id下的商品
	 */
	public List<Product> findByCategoryLevel2Id(Connection con,Integer categoryLevel2Id,PageBean pageBean);
	
	/**
	 * 查询商品三级类别id下的商品
	 */
	public List<Product> findByCategoryLevel3Id(Connection con,Integer categoryLevel3Id,PageBean pageBean);
	
	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con,Integer categoryLevel1Id,String type,String keyWord);
	
	
	/**
	 * 商品id查询商品信息
	 * @param con
	 * @param id
	 * @return
	 */
	public Product findById(Connection con,Integer id);
	
	/**
	 * 商品修改
	 * @return
	 */
	public int update(Connection con,Product product);
	
	/**
	 * 商品删除
	 * @return
	 */
	public int delete(Connection con,Integer id);
	
	/**
	 * 商品添加
	 * @param con
	 * @param product
	 * @return
	 */
	public int add(Connection con,Product product);
	
	/**
	 * 更新商品表的库存
	 * @param id
	 * @param quantity
	 * @return
	 */
	public Integer updateStock(Connection con,Integer id, Integer quantity);
	
}
