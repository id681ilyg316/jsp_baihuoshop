package com.EasyBuy.Dao.User.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyBuy.Dao.BaseDao;
import com.EasyBuy.Dao.User.UserDao;
import com.EasyBuy.entity.User;
import com.EasyBuy.util.SecurityUtils;
import com.EasyBuy.entity.User;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.User;

/**
 * 用户Dao接口实现
 * @author Administrator
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	
	private ResultSet rs=null;
	
	
	/**
	 * 用户登录
	 * @param con
	 * @param user
	 * @return
	 */
	public User login(Connection con,User user) {
		String sql="select * from easybuy_user where loginName=? and password=?";
		User currentUser = null;
		Object [] params= {
				user.getLoginName(),
				SecurityUtils.md5Hex(user.getPassword())
		};
		try {
			rs=executeQuery(con, sql, params);
			if(rs.next()) {
				currentUser=new User();
				currentUser.setId(rs.getInt("id"));
				currentUser.setLoginName(rs.getString("loginName"));
				currentUser.setUserName(rs.getString("userName"));
				currentUser.setPassword(rs.getString("password"));
				currentUser.setSex(rs.getInt("sex"));
				currentUser.setIdentityCode(rs.getString("identityCode"));
				currentUser.setEmail(rs.getString("email"));
				currentUser.setMobile(rs.getString("mobile"));
				currentUser.setType(rs.getInt("type"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentUser;
	}
	
	
	
	
	/**
	 * 分页查询用户
	 * @param con
	 * @param pageBean
	 * @return
	 */
	@Override
	public List<User> list(Connection con, PageBean pageBean) {
		StringBuffer sb=new StringBuffer("select * from easybuy_user ");
		List<User> userList=new ArrayList<>();
		
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginName"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setIdentityCode(rs.getString("identityCode"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setType(rs.getInt("type"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 查询用户总记录数
	 * @param con
	 * @return
	 */
	@Override
	public int getCount(Connection con) {
		StringBuffer sb=new StringBuffer("select count(*) as total from easybuy_user ");
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
	 * 用户id查询用户信息
	 * @param con
	 * @param id
	 * @return
	 */
	@Override
	public User findUserDetail(Connection con, Integer id) {
		String sql="select * from easybuy_user where id="+id;
		User user=null;
		rs=executeQuery(con,sql,null);
		try {
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginName"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setIdentityCode(rs.getString("identityCode"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setType(rs.getInt("type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return user;
	}

	/**
	 * 删除用户
	 */
	@Override
	public int delele(Connection con, Integer id) {
		String sql="delete from easybuy_user where id="+id;
		int index=executeUpdate(con, sql, null);
		return index;
	}

	
	
	/**
	 * 注册用户
	 * @param con
	 * @param user
	 * @return
	 */
	public int register(Connection con,User user) {
		String sql="insert into easybuy_user values(null,?,?,?,?,?,?,?,?)";
		Object [] params= {
				user.getLoginName(),
				user.getUserName(),
				SecurityUtils.md5Hex(user.getPassword()),
				user.getSex(),
				user.getIdentityCode(),
				user.getEmail(),
				user.getMobile(),
				user.getType()
		};
		int index=executeUpdate(con, sql, params);
		return index;
	}

	/**
	 * 删除用户
	 */
	@Override
	public int update(Connection con, User user) {
		String sql="update easybuy_user set loginName=?,userName=?,password=?,sex=?,identityCode=?,email=?,mobile=?,type=? where id=?";
		Object [] params= {
				user.getLoginName(),
				user.getUserName(),
				SecurityUtils.md5Hex(user.getPassword()),
				user.getSex(),
				user.getIdentityCode(),
				user.getEmail(),
				user.getMobile(),
				user.getType(),
				user.getId()
		};
		int index=executeUpdate(con, sql, params);
		return index;
	}

}
