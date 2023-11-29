package com.EasyBuy.Dao.Product.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyBuy.Dao.BaseDao;
import com.EasyBuy.Dao.Product.ProductCategoryDao;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.ProductCategory;

public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao{

	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	
	/**
	 * type查询商品类别
	 * @return
	 */
	@Override
	public List<ProductCategory> Categorylist(Connection con,Integer type) {
		String sql="select * from easybuy_product_category where type="+type;
		List<ProductCategory> categoryList1=new ArrayList<>();
		try {
			rs=executeQuery(con,sql,null);
			while(rs.next()) {
				ProductCategory productCategory=new ProductCategory();
				productCategory.setId(rs.getInt("id"));
				productCategory.setName(rs.getString("name"));
				productCategory.setParentId(rs.getInt("parentId"));
				productCategory.setType(rs.getInt("type"));
				productCategory.setIconClass(rs.getString("iconClass"));
				categoryList1.add(productCategory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList1;
	}

	/**
	 * 查询下级类别
	 * @param con
	 * @param type
	 * @param parentId
	 * @return
	 */
	@Override
	public List<ProductCategory> childCategorylist(Connection con, Integer type, Integer parentId) {
		String sql;
		List<ProductCategory> childcategoryList=new ArrayList<>();
		if(parentId!=null) {
			 sql="select * from easybuy_product_category where parentId=? and  type=?";
			 try {
				Object [] params= {
						parentId,
						type
				};
				rs=executeQuery(con,sql,params);
				while(rs.next()) {
					ProductCategory productCategory=new ProductCategory();
					productCategory.setId(rs.getInt("id"));
					productCategory.setName(rs.getString("name"));
					productCategory.setParentId(rs.getInt("parentId"));
					productCategory.setType(rs.getInt("type"));
					productCategory.setIconClass(rs.getString("iconClass"));
					childcategoryList.add(productCategory);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return childcategoryList;
	}
	
	

	/**
	 * 查询商品所有类别
	 * @param con
	 * @return
	 */
	@Override
	public List<ProductCategory> list(Connection con,PageBean pageBean) {
		StringBuffer sb=new StringBuffer("select * from easybuy_product_category ");
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		List<ProductCategory> categoryList=new ArrayList<>();
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				ProductCategory productCategory=new ProductCategory();
				productCategory.setId(rs.getInt("id"));
				productCategory.setName(rs.getString("name"));
				productCategory.setParentId(rs.getInt("parentId"));
				productCategory.setType(rs.getInt("type"));
				productCategory.setIconClass(rs.getString("iconClass"));
				categoryList.add(productCategory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	
	
	/**
	 * 查询父级类别
	 * @param con
	 * @param parentId
	 * @return
	 */
	public ProductCategory findParentCategory(Connection con,Integer parentId) {
		String sql="select * from easybuy_product_category where id="+parentId;
		ProductCategory productCategory=null;
		try {
			rs=executeQuery(con, sql, null);
			if(rs.next()) {
				productCategory=new ProductCategory();
				productCategory.setId(rs.getInt("id"));
				productCategory.setName(rs.getString("name"));
				productCategory.setParentId(rs.getInt("parentId"));
				productCategory.setType(rs.getInt("type"));
				productCategory.setIconClass(rs.getString("iconClass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategory;
		
	}

	/**
	 * 查询商品类别总记录数
	 * @param con
	 * @return
	 */
	@Override
	public int getCount(Connection con) {
		StringBuffer sb=new StringBuffer("select count(*) as total from easybuy_product_category ");
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
	 * 添加商品分类
	 * @param con
	 * @param sql
	 * @param parentId
	 * @param type
	 * @return
	 */
	public int insert(Connection con,String name,Integer parentId,Integer type) {
		String sql="insert into easybuy_product_category(name,parentId,type) values(?,?,?)";
		int index=0;
		try {
			Object [] params= {
					name,
					parentId,
					type
			};
			index=executeUpdate(con,sql,params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return index;
		
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
		int index=0;
		String sql="update  easybuy_product_category set name=?,parentId=?,type=? where id=?";
		try {
			Object [] params= {
					name,
					parentId,
					type,
					id
			};
			index=executeUpdate(con,sql,params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return index;
		
	}
	
	/**
	 * 删除商品分类
	 * @param con
	 * @param id
	 * @return
	 */
	public int deleteProductCategory(Connection con,Integer id) {
		String sql="delete from easybuy_product_category where id="+id;
		int index=0;
		try {
			index=executeUpdate(con,sql,null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return index;
		
	}
	
	/**
	 * 通过主键id查询对应商品类别
	 * @return
	 */
	public ProductCategory findByid(Connection con,Integer id) {
		String sql="select * from easybuy_product_category where id="+id;
		ProductCategory productCategory=new ProductCategory();
		try {
			rs=executeQuery(con,sql,null);
			if(rs.next()) {
				productCategory.setId(rs.getInt("id"));
				productCategory.setName(rs.getString("name"));
				productCategory.setParentId(rs.getInt("parentId"));
				productCategory.setType(rs.getInt("type"));
				productCategory.setIconClass(rs.getString("iconClass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategory;
	}
	
	
	
}
