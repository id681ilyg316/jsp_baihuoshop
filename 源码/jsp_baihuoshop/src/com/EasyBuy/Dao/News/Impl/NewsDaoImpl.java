package com.EasyBuy.Dao.News.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyBuy.Dao.BaseDao;
import com.EasyBuy.Dao.News.NewsDao;
import com.EasyBuy.entity.News;
import com.EasyBuy.entity.PageBean;
import com.EasyBuy.entity.Product;
import com.EasyBuy.util.DateUtil;

public class NewsDaoImpl extends BaseDao implements NewsDao{

	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	
	/**
	 * 分页查询咨询
	 * @return
	 */
	@Override
	public List<News> list(Connection con, PageBean pageBean) {
		StringBuffer sb=new StringBuffer("select * from easybuy_news ");
		List<News> newsList=new ArrayList<>();
		
		sb.append(" order by createTime desc"); 	
		
		if(pageBean!=null) {
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		try {
			rs=executeQuery(con,sb.toString(),null);
			while(rs.next()) {
				News news=new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				//news.setCreateTime(DateUtil.formatString(rs.getString("createTime"), "yyyy-mm-dd") );
				news.setCreateTime(rs.getDate("createTime"));
				newsList.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	@Override
	public int getCount(Connection con) {
		StringBuffer sb=new StringBuffer("select count(*) as total from easybuy_news ");
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
	 * 咨询id查询咨询详情
	 * @param con
	 * @param id
	 * @return
	 */
	public News findNewsDetail(Connection con,Integer id) {
		String sql="select * from easybuy_news where id="+id;
		News news=null;
		rs=executeQuery(con,sql,null);
		try {
			if(rs.next()) {
				news=new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				//news.setCreateTime(DateUtil.formatString(rs.getString("createTime"), "yyyy-mm-dd") );
				news.setCreateTime(rs.getDate("createTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return news;
	}
	
	/**
	 * 删除资讯
	 * @param con
	 * @param id
	 * @return
	 */
	public int delele(Connection con,Integer id) {
		String sql="delete from easybuy_news where id="+id;
		int index=executeUpdate(con, sql, null);
		return index;
	}

	/**
	 * 添加资讯
	 * @param con
	 * @param news
	 * @return
	 */
	public int insert(Connection con,News news) {
		String sql="insert into easybuy_news(title,content,createTime) values(?,?,?)";
		Object [] params= {
				news.getTitle(),
				news.getContent(),
				news.getCreateTime()
		};
		int index=executeUpdate(con, sql, params);
		return index;
		
	}
	
	/**
	 * 修改资讯
	 * @param con
	 * @param news
	 * @return
	 */
	public int update(Connection con,News news) {
		String sql="update easybuy_news set title=?,content=?,createTime=? where id=?";
		Object [] params= {
				news.getTitle(),
				news.getContent(),
				news.getCreateTime(),
				news.getId()
		};
		int index=executeUpdate(con, sql, params);
		return index;
	}
}
