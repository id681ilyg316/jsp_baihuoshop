package com.EasyBuy.web.pre;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyBuy.Service.User.UserService;
import com.EasyBuy.Service.User.Impl.UserServiceImpl;
import com.EasyBuy.entity.User;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.ResponseUtil;

import net.sf.json.JSONObject;

@WebServlet(urlPatterns = {"/user"})
public class UserServlet extends HttpServlet{

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
		if("register".equals(action)) {
			this.register(request,response);
		}
	}

	/**
	 * 注册用户
	 * @param request
	 * @param response
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String loginName=request.getParameter("loginName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String identityCode=request.getParameter("identityCode");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		int index=0;
		try {
			con=dbutil.getCon();
			JSONObject result=new JSONObject();
			User user=new User(loginName,userName,password,Integer.parseInt(sex),identityCode,email,mobile,0);
			index=userService.register(con, user);
			if(index>0) {
				result.put("success", true);
			}else {
				result.put("error", "注册失败");
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	
	

}
