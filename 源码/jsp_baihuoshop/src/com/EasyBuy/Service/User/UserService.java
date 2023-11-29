package com.EasyBuy.Service.User;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.User;

/**
 * 用户Service接口
 * @author Administrator
 *
 */
public interface UserService {
	
	/**
	 * 用户登录
	 * @param con
	 * @param user
	 * @return
	 */
	public User login(Connection con,User user);
	
	/**
	 * 注册用户
	 * @param con
	 * @param user
	 * @return
	 */
	public int register(Connection con,User user);
	
	/**
	 * 分页查询用户
	 * @param con
	 * @param pageBean
	 * @return
	 */
	public List<User> list(Connection con,PageBean pageBean);
	
	/**
	 * 查询用户总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con);
	
	/**
	 * 用户id查询用户信息
	 * @param con
	 * @param id
	 * @return
	 */
	public User findUserDetail(Connection con,Integer id);
	
	/**
	 * 删除用户
	 * @param con
	 * @param id
	 * @return
	 */
	public int delele(Connection con,Integer id);
	
	/**
	 * 添加用户
	 * @param con
	 * @param user
	 * @return
	 *//*
	public int insert(Connection con,User user);*/
	
	/**
	 * 修改用户
	 * @param con
	 * @param user
	 * @return
	 */
	public int update(Connection con,User user);
}
