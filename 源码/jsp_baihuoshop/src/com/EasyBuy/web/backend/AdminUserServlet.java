package com.EasyBuy.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EasyBuy.Service.User.UserService;
import com.EasyBuy.Service.User.Impl.UserServiceImpl;
import com.EasyBuy.entity.User;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.PageUtil;
import com.EasyBuy.util.PropertiesUtil;
import com.EasyBuy.util.ResponseUtil;
import com.EasyBuy.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet(urlPatterns = {"/admin/user"})
public class AdminUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbutil=new DbUtil();
	UserService userService=new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if("login".equals(action)) {
			this.login(request,response);
		}else if("userDetail".equals(action)) {
			this.userDetail(request,response);
		}else if("queryUserList".equals(action)) {
			this.queryUserList(request,response);
		}else if("deleteUserById".equals(action)) {
			this.deleteUserById(request,response);
		}else if("presave".equals(action)) {
			this.presave(request,response);
		}else if("save".equals(action)) {
			this.save(request,response);
		}else if("logout".equals(action)) {
			this.logout(request,response);
		}
		
	}

	/**
	 * 注销
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUser");
		try {
			request.getRequestDispatcher("/init").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 保存用户
	 * @param request
	 * @param response
	 */
	public void save(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String loginName=request.getParameter("loginName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String identityCode=request.getParameter("identityCode");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String type=request.getParameter("type");
		Connection con=null;
		int index=0;
		try {
			JSONObject result=new JSONObject();
			con=dbutil.getCon();
			if(StringUtil.isNotEmpty(id)) {
				//修改
				User user=new User(Integer.parseInt(id),loginName,userName,password,Integer.parseInt(sex),identityCode,email,mobile,Integer.parseInt(type));
				index=userService.update(con, user);
				if(index>0) {
					result.put("success", true);
				}else {
					result.put("error", "修改失败");
				}
			}else {
				//添加
				User user=new User(loginName,userName,password,Integer.parseInt(sex),identityCode,email,mobile,Integer.parseInt(type));
				index=userService.register(con, user);
				if(index>0) {
					result.put("success", true);
				}else {
					result.put("error", "添加失败");
				}
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
	}

	/**
	 * 添加和修改跳转
	 * @param request
	 * @param response
	 */
	public void presave(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		Connection con=null;
		try {
			con=dbutil.getCon();
			if(StringUtil.isEmpty(id)) {
				//添加跳转
				request.setAttribute("mainPage", "user/UserModify.jsp");
			}else {
				//修改跳转
				User user=userService.findUserDetail(con, Integer.parseInt(id));
				request.setAttribute("user", user);
				request.setAttribute("mainPage", "user/UserModify.jsp");
			}
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
	}

	/**
	 * 删除用户
	 * @param request
	 * @param response
	 */
	public void deleteUserById(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String id=request.getParameter("id");
		JSONObject result=new JSONObject();
		try {
			con=dbutil.getCon();
			int index=userService.delele(con, Integer.parseInt(id));
			if(index>0) {
				result.put("status", 1);
			}else {
				result.put("status", 2);
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 分页查询用户
	 * @param request
	 * @param response
	 */
	public void queryUserList(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String page=request.getParameter("page");
		
		try {
			con=dbutil.getCon();
			int total=userService.getCount(con);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("pageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("pageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("pageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			List<User> userList=userService.list(con,pageBean);
			request.setAttribute("menu", 8);
			request.setAttribute("userList", userList);
			request.setAttribute("pageCode", PageUtil.getPagation("user?action=queryUserList",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			request.setAttribute("mainPage", "user/userList.jsp");
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 查询用户详细信息
	 * @param request
	 * @param response
	 */
	public void userDetail(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		Connection con=null;
		try {
			con=dbutil.getCon();
			if(StringUtil.isEmpty(id)) {
				request.getRequestDispatcher("/Pre/login.jsp").forward(request, response);
			}else {
				User user=userService.findUserDetail(con, Integer.parseInt(id));
				request.setAttribute("user", user);
				request.setAttribute("menu", 2);
				request.setAttribute("mainPage", "user/userDetail.jsp");
				request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		/*ServletContext application = request.getSession().getServletContext(); */
		try {
			con=dbutil.getCon();
			User currentUser=userService.login(con, new User(loginName,password));
			session.setAttribute("currentUser", currentUser);
			JSONObject result=new JSONObject();
			if(currentUser!=null) {
				result.put("status", 1);
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
