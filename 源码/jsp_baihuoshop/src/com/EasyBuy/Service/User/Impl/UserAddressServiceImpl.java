package com.EasyBuy.Service.User.Impl;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.Dao.User.UserAddressDao;
import com.EasyBuy.Dao.User.Impl.UserAddressDaoImpl;
import com.EasyBuy.Service.User.UserAddressService;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.UserAddress;

/**
 * 用户地址Service接口实现
 * @author Administrator
 *
 */
public class UserAddressServiceImpl implements UserAddressService{

	UserAddressDao userAddressDao =new UserAddressDaoImpl();
	
	@Override
	public List<UserAddress> list(Connection con) {
		// TODO Auto-generated method stub
		return userAddressDao.list(con);
	}
	
	/**
	 * id查询地址
	 * @param con
	 * @param id
	 * @return
	 */
	public UserAddress findById(Connection con,Integer id) {
		return userAddressDao.findById(con, id);
		
	}

	/**
	 * 查询用户地址总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con) {
		return userAddressDao.getCount(con);
		
	}
	
	@Override
	public int insert(Connection con, UserAddress userAddress) {
		// TODO Auto-generated method stub
		return userAddressDao.insert(con, userAddress);
	}
	
	
}
