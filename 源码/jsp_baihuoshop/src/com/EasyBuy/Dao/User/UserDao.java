package com.EasyBuy.Dao.User;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.User;
import com.EasyBuy.entity.PageBean;

/**
 * 用户Dao接口
 * @author Administrator
 *
 */
public interface UserDao {
	
	/**
	 * 分页查询用户
	 * @param con
	 * @param pageBean
	 * @return
	 */
	public List<User> list(Connection con,PageBean pageBean);
	
	
	
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
	 * 修改用户
	 * @param con
	 * @param user
	 * @return
	 */
	public int update(Connection con,User user);
}
