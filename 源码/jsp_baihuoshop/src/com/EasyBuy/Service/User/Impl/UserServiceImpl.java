package com.EasyBuy.Service.User.Impl;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.Dao.User.UserDao;
import com.EasyBuy.Dao.User.Impl.UserDaoImpl;
import com.EasyBuy.Service.User.UserService;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.User;

/**
 * 用户Service接口实现
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{

	UserDao userDao=new UserDaoImpl();
	
	
	/**
	 * 用户登录
	 * @param con
	 * @param user
	 * @return
	 */
	public User login(Connection con,User user) {
		return userDao.login(con, user);
		
	}
	
	/**
	 * 注册用户
	 * @param con
	 * @param user
	 * @return
	 */
	public int register(Connection con,User user) {
		return userDao.register(con, user);
		
	}
	
	/**
	 * 分页查询用户
	 * @param con
	 * @param pageBean
	 * @return
	 */
	@Override
	public List<User> list(Connection con, PageBean pageBean) {
		// TODO Auto-generated method stub
		return userDao.list(con, pageBean);
	}

	/**
	 * 查询用户总记录数
	 * @param con
	 * @return
	 */
	@Override
	public int getCount(Connection con) {
		// TODO Auto-generated method stub
		return userDao.getCount(con);
	}

	
	/**
	 * 用户id查询用户信息
	 * @param con
	 * @param id
	 * @return
	 */
	@Override
	public User findUserDetail(Connection con, Integer id) {
		// TODO Auto-generated method stub
		return userDao.findUserDetail(con, id);
	}

	/**
	 * 删除用户
	 * @param con
	 * @param id
	 * @return
	 */
	@Override
	public int delele(Connection con, Integer id) {
		// TODO Auto-generated method stub
		return userDao.delele(con, id);
	}

	/**
	 * 添加用户
	 * @param con
	 * @param user
	 * @return
	 */
//	@Override
//	public int insert(Connection con, User user) {
//		// TODO Auto-generated method stub
//		return userDao.insert(con, user);
//	}

	/**
	 * 修改用户
	 * @param con
	 * @param user
	 * @return
	 */
	@Override
	public int update(Connection con, User user) {
		// TODO Auto-generated method stub
		return userDao.update(con, user);
	}

}
