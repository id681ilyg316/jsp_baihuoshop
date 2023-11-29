package com.EasyBuy.Service.Product.Impl;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.Dao.Product.ProductDao;
import com.EasyBuy.Dao.Product.Impl.ProductDaoImpl;
import com.EasyBuy.Service.Product.ProductService;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;

public class ProductServiceImpl implements ProductService{

	ProductDao productDao=new ProductDaoImpl();
	
	/**
	 * 商品查询
	 * @return
	 */
	@Override
	public List<Product> list(Connection con,PageBean pageBean,String keyWord) {
		// TODO Auto-generated method stub
		return productDao.list(con,pageBean,keyWord);
	}
	
	/**
	 * 查询商品一级类别id下的商品
	 */
	public List<Product> findByCategoryLevel1Id(Connection con,Integer categoryLevel1Id,PageBean pageBean){
		return productDao.findByCategoryLevel1Id(con, categoryLevel1Id,pageBean);
		
	}
	
	/**
	 * 查询商品二级类别id下的商品
	 */
	public List<Product> findByCategoryLevel2Id(Connection con,Integer categoryLevel2Id,PageBean pageBean){
		return productDao.findByCategoryLevel2Id(con, categoryLevel2Id, pageBean);
		
	}
	
	/**
	 * 查询商品三级类别id下的商品
	 */
	public List<Product> findByCategoryLevel3Id(Connection con,Integer categoryLevel3Id,PageBean pageBean){
		return productDao.findByCategoryLevel3Id(con, categoryLevel3Id, pageBean);
		
	}
	
	
	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con,Integer categoryLevel1Id,String type,String keyWord) {
		return productDao.getCount(con,categoryLevel1Id,type,keyWord);
		
	}
	
	/**
	 * 商品id查询商品信息
	 * @param con
	 * @param id
	 * @return
	 */
	public Product findById(Connection con,Integer id) {
		return productDao.findById(con, id);
		
	}

	/**
	 * 商品修改
	 * @return
	 */
	@Override
	public int update(Connection con, Product product) {
		// TODO Auto-generated method stub
		return productDao.update(con, product);
	}
	
	
	/**
	 * 商品删除
	 * @return
	 */
	@Override
	public int delete(Connection con, Integer id) {
		// TODO Auto-generated method stub
		return productDao.delete(con, id);
	}

	/**
	 * 商品添加
	 * @param con
	 * @param product
	 * @return
	 */
	@Override
	public int add(Connection con, Product product) {
		// TODO Auto-generated method stub
		return productDao.add(con, product);
	}

	
	/**
	 * 更新商品表的库存
	 * @param id
	 * @param quantity
	 * @return
	 */
	public Integer updateStock(Connection con,Integer id, Integer quantity) {
		return productDao.updateStock(con, id, quantity);
		
	}
}
