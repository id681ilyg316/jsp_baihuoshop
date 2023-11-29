package com.EasyBuy.Dao.User.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyBuy.Dao.BaseDao;
import com.EasyBuy.Dao.User.UserAddressDao;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.User;
import com.EasyBuy.entity.UserAddress;
import com.EasyBuy.util.SecurityUtils;

/**
 * 用户地址Dao接口实现
 * @author Administrator
 *
 */
public class UserAddressDaoImpl extends BaseDao implements UserAddressDao{
	private ResultSet rs=null;
	
	/**
	 * 分页查询地址
	 * @param con
	 * @param pageBean
	 * @return
	 */
	@Override
	public List<UserAddress> list(Connection con) {
		StringBuffer sb=new StringBuffer("select * from easybuy_user_address") ;
		List<UserAddress> userAddressList=new ArrayList<>();
		
		
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				UserAddress userAddress=new UserAddress();
				userAddress.setId(rs.getInt("id"));
				userAddress.setUserId(rs.getInt("userId"));
				userAddress.setAddress(rs.getString("address"));
				userAddress.setCreateTime(rs.getDate("createTime"));
				userAddress.setIsDefault(rs.getInt("isDefault"));
				userAddress.setRemark(rs.getString("remark"));
				userAddressList.add(userAddress);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAddressList;
	}

	/**
	 * 添加地址
	 * @param con
	 * @param userAddress
	 * @return
	 */
	@Override
	public int insert(Connection con, UserAddress userAddress) {
		int id=0;
		String sql="insert into easybuy_user_address(userId,address,createTime,remark) values(?,?,now(),?)";
		Object [] params= {
				userAddress.getUserId(),
				userAddress.getAddress(),
				//userAddress.getIsDefault(),
				userAddress.getRemark()
		};
		
		id=executeInsert(con, sql, params);
		return id;
	}

	@Override
	public int getCount(Connection con) {
		StringBuffer sb=new StringBuffer("select count(*) as total from easybuy_user_address ");
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
	 * id查询地址
	 * @param con
	 * @param id
	 * @return
	 */
	@Override
	public UserAddress findById(Connection con, Integer id) {
		String sql="select * from easybuy_user_address where id="+id;
		UserAddress userAddress=null;
		try {
			rs=executeQuery(con, sql, null);
			if(rs.next()) {
				userAddress=new UserAddress();
				userAddress.setId(rs.getInt("id"));
				userAddress.setUserId(rs.getInt("userId"));
				userAddress.setAddress(rs.getString("address"));
				userAddress.setCreateTime(rs.getDate("createTime"));
				userAddress.setIsDefault(rs.getInt("isDefault"));
				userAddress.setRemark(rs.getString("remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAddress;
	}

}
