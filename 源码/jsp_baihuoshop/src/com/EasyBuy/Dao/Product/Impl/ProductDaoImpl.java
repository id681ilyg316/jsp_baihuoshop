package com.EasyBuy.Dao.Product.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyBuy.Dao.BaseDao;
import com.EasyBuy.Dao.Product.ProductDao;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;
import com.EasyBuy.util.StringUtil;

/**
 * 商品Dao接口实现
 * @author Administrator
 *
 */
public class ProductDaoImpl extends BaseDao implements  ProductDao{

	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	/**
	 * 商品查询
	 * @return
	 */
	@Override
	public List<Product> list(Connection con,PageBean pageBean,String keyWord) {
		StringBuffer sb=new StringBuffer("select * from easybuy_product where isDelete=0");
		List<Product> productList=new ArrayList<>();
		
		if(StringUtil.isNotEmpty(keyWord)) {
			sb.append(" and name like '%"+keyWord+"%'");
		}
		
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
				product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
				product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
				product.setFileName(rs.getString("fileName"));
				product.setIsDelete(rs.getInt("isDelete"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	/**
	 * 查询商品一级类别id下的商品
	 */
	public List<Product> findByCategoryLevel1Id(Connection con,Integer categoryLevel1Id,PageBean pageBean){
		StringBuffer sb=new StringBuffer("select * from easybuy_product where isDelete=0 and categoryLevel1Id="+categoryLevel1Id);
		List<Product> productList=new ArrayList<>();
		
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
				product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
				product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
				product.setFileName(rs.getString("fileName"));
				product.setIsDelete(rs.getInt("isDelete"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
		
	}
	
	/**
	 * 查询商品二级类别id下的商品
	 */
	public List<Product> findByCategoryLevel2Id(Connection con,Integer categoryLevel2Id,PageBean pageBean){
		StringBuffer sb=new StringBuffer("select * from easybuy_product where isDelete=0 and categoryLevel2Id="+categoryLevel2Id);
		List<Product> productList=new ArrayList<>();
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
				product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
				product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
				product.setFileName(rs.getString("fileName"));
				product.setIsDelete(rs.getInt("isDelete"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	/**
	 * 查询商品二级类别id下的商品
	 */
	public List<Product> findByCategoryLevel3Id(Connection con,Integer categoryLevel3Id,PageBean pageBean){
		StringBuffer sb=new StringBuffer("select * from easybuy_product where isDelete=0 and categoryLevel3Id="+categoryLevel3Id);
		List<Product> productList=new ArrayList<>();
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
				product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
				product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
				product.setFileName(rs.getString("fileName"));
				product.setIsDelete(rs.getInt("isDelete"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
		
	}

	/**
	 * 商品修改
	 * @return
	 */
	@Override
	public int update(Connection con, Product product) {
		String sql="update easybuy_product set name=?,description=?, price=?,  stock=?, categoryLevel1Id=?,  categoryLevel2Id=?,  categoryLevel3Id=?,  fileName=? where id=?";
		int index=0;
		try {
			Object [] params= {
					product.getName(),
					product.getDescription(),
					product.getPrice(),
					product.getStock(),
					product.getCategoryLevel1Id(),
					product.getCategoryLevel2Id(),
					product.getCategoryLevel3Id(),
					product.getFileName(),
					product.getId()
			};
			index=executeUpdate(con,sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index;
	}

	/**
	 * 商品删除
	 * @return
	 */
	@Override
	public int delete(Connection con, Integer id) {
		String sql="update easybuy_product set isDelete=1 where id="+id;
		Integer index=0;
		try {
			index=executeUpdate(con,sql,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index;
		
	}

	/**
	 * 商品添加
	 * @param con
	 * @param product
	 * @return
	 */
	@Override
	public int add(Connection con, Product product) {
		String sql="insert into easybuy_product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName) values(?,?,?,?,?,?,?,?)";
		int index=0;
		try {
			Object [] params= {
					product.getName(),
					product.getDescription(),
					product.getPrice(),
					product.getStock(),
					product.getCategoryLevel1Id(),
					product.getCategoryLevel2Id(),
					product.getCategoryLevel3Id(),
					product.getFileName()
			};
			index=executeUpdate(con, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index;
	}

	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	@Override
	public int getCount(Connection con,Integer categoryLeveId,String type,String keyWord) {
		StringBuffer sb=new StringBuffer("select count(*) as total from easybuy_product where isDelete=0");
		if("1".equals(type)) {
			sb.append(" and categoryLevel1Id="+categoryLeveId);
		}else if("2".equals(type)) {
			sb.append(" and categoryLevel2Id="+categoryLeveId);
		}else if("3".equals(type)) {
			sb.append(" and categoryLevel3Id="+categoryLeveId);
		}
		
		if(StringUtil.isNotEmpty(keyWord)) {
			sb.append(" and name like '%"+keyWord+"%'");
		}
		
		int total=0;
		try {
			rs=executeQuery(con,sb.toString(),null);
			if(rs.next()) {
				total=rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	
	/**
	 * 商品id查询商品信息
	 * @param con
	 * @param id
	 * @return
	 */
	@Override
	public Product findById(Connection con, Integer id) {
		String sql="select * from easybuy_product where id="+id;
		Product product=null;
		try {
			rs=executeQuery(con,sql,null);
			if(rs.next()) {
				product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
				product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
				product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
				product.setFileName(rs.getString("fileName"));
				product.setIsDelete(rs.getInt("isDelete"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	/**
	 * 更新商品表的库存
	 * @param id
	 * @param quantity
	 * @return
	 */
	public Integer updateStock(Connection con,Integer id, Integer quantity) {
	       Integer count=0;
	        try {
	        	Object[] params = new Object[] {quantity,id};
	        	String sql = " update easybuy_product set stock=? where id=? ";
				count=executeUpdate(con,sql, params);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return count;
	    }

}
