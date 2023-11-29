package com.EasyBuy.Dao.User;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.UserAddress;

/**
 * 用户地址接口
 * @author Administrator
 *
 */
public interface UserAddressDao {
	
	/**
	 * 分页查询地址
	 * @param con
	 * @param pageBean
	 * @return
	 */
	public List<UserAddress> list(Connection con);
	
	/**
	 * 查询用户地址总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con);
	
	/**
	 * id查询地址
	 * @param con
	 * @param id
	 * @return
	 */
	public UserAddress findById(Connection con,Integer id);
	
	/**
	 * 添加地址
	 * @param con
	 * @param userAddress
	 * @return
	 */
	public int insert(Connection con,UserAddress userAddress);
}
