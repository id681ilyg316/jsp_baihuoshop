package com.EasyBuy.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EasyBuy.Service.News.NewsService;
import com.EasyBuy.Service.News.Impl.NewsServiceImpl;
import com.EasyBuy.entity.News;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.util.DateUtil;
import com.EasyBuy.util.DbUtil;
import com.EasyBuy.util.PageUtil;
import com.EasyBuy.util.PropertiesUtil;
import com.EasyBuy.util.ResponseUtil;
import com.EasyBuy.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet(urlPatterns = {"/admin/news"})
public class AdminNewsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	NewsService newsService=new NewsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if("index".equals(action)) {
			this.list(request,response);
		}else if("newsDetail".equals(action)) {
			this.newsDetail(request,response);
		}else if("delete".equals(action)) {
			this.deleteNews(request,response);
		}else if("presave".equals(action)) {
			this.Presave(request,response);
		}else if("save".equals(action)) {
			this.save(request,response);
		}
	}

	/**
	 * 保存资讯
	 * @param request
	 * @param response
	 */
	public void save(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String newsContent=request.getParameter("newsContent");
		String date=request.getParameter("test1");
		Connection con=null;
		int index=0;
		try {
			
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(id)) {
				//修改
				News news=new News(Integer.parseInt(id),title,newsContent,DateUtil.formatString(date, "yyyy-MM-dd"));
				index=newsService.update(con, news);
			}else {
				//添加
				News news=new News(title,newsContent,DateUtil.formatString(date, "yyyy-MM-dd"));
				newsService.insert(con, news);
			}
			request.getRequestDispatcher("/admin/news?action=index").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	/**
	 * 资讯添加和修改跳转
	 * @param request
	 * @param response
	 */
	public void Presave(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			if(StringUtil.isEmpty(id)) {
				//添加跳转
				request.setAttribute("mainPage", "news/NewModify.jsp");
			}else {
				//修改跳转
				News news=newsService.findNewsDetail(con,Integer.parseInt(id));
				request.setAttribute("news", news);
				request.setAttribute("mainPage", "news/NewModify.jsp");
			}
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	/**
	 * 删除资讯
	 * @param request
	 * @param response
	 */
	public void deleteNews(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String id=request.getParameter("id");
		JSONObject result=new JSONObject();
		try {
			con=dbUtil.getCon();
			int index=newsService.delele(con, Integer.parseInt(id));
			if(index>0) {
				result.put("success", true);
			}else {
				result.put("success", false);
			}
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询咨询详情
	 * @param request
	 * @param response
	 */
	public void newsDetail(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String id=request.getParameter("id");
		try {
			con=dbUtil.getCon();
			News news=newsService.findNewsDetail(con, Integer.parseInt(id));
			request.setAttribute("news", news);
			request.setAttribute("mainPage", "news/newsDetail.jsp");
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 分页查询咨询
	 * @param request
	 * @param response
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) {
		Connection con=null;
		String page=request.getParameter("page");
		
		try {
			con=dbUtil.getCon();
			int total=newsService.getCount(con);
			int totalPage=total%Integer.parseInt(PropertiesUtil.getValue("pageSize"))==0?total/Integer.parseInt(PropertiesUtil.getValue("pageSize")):(total/Integer.parseInt(PropertiesUtil.getValue("pageSize")))+1;//总页数
			if(StringUtil.isEmpty(page) || Integer.parseInt(page)>totalPage) {
				page="1";
			}
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(PropertiesUtil.getValue("pageSize")));
			List<News> newsList=newsService.list(con,pageBean);
			request.setAttribute("menu", 7);
			request.setAttribute("newsList", newsList);
			request.setAttribute("pageCode", PageUtil.getPagation("news?action=index",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")))); 
			request.setAttribute("mainPage", "news/newsList.jsp");
			request.getRequestDispatcher("/backend/backendMain.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
