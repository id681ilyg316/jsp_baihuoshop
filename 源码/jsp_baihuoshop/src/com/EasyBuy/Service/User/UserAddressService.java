package com.EasyBuy.Service.User;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.UserAddress;

/**
 * 用户地址Service接口
 * @author Administrator
 *
 */
public interface UserAddressService {

	/**
	 * 分页查询地址
	 * @param con
	 * @param pageBean
	 * @return
	 */
	public List<UserAddress> list(Connection con);
	
	/**
	 * id查询地址
	 * @param con
	 * @param id
	 * @return
	 */
	public UserAddress findById(Connection con,Integer id);
	
	/**
	 * 查询用户地址总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con);
	
	/**
	 * 添加地址
	 * @param con
	 * @param userAddress
	 * @return
	 */
	public int insert(Connection con,UserAddress userAddress);
}
