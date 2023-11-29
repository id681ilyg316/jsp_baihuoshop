package com.EasyBuy.Service.News.Impl;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.Dao.News.NewsDao;
import com.EasyBuy.Dao.News.Impl.NewsDaoImpl;
import com.EasyBuy.Service.News.NewsService;
import com.EasyBuy.entity.News;
import com.EasyBuy.entity.PageBean;

/**
 * 咨询Service接口实现
 * @author Administrator
 *
 */
public class NewsServiceImpl implements NewsService{

	NewsDao newsDao=new NewsDaoImpl();
	
	/**
	 * 分页查询咨询
	 * @return
	 */
	@Override
	public List<News> list(Connection con, PageBean pageBean) {
		return newsDao.list(con, pageBean);
	}

	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	@Override
	public int getCount(Connection con) {
		return newsDao.getCount(con);
	}
	
	/**
	 * 咨询id查询咨询详情
	 * @param con
	 * @param id
	 * @return
	 */
	public News findNewsDetail(Connection con,Integer id) {
		return newsDao.findNewsDetail(con, id);
	}

	/**
	 * 删除资讯
	 * @param con
	 * @param id
	 * @return
	 */
	public int delele(Connection con,Integer id) {
		return newsDao.delele(con, id);
		
	}
	
	/**
	 * 添加资讯
	 * @param con
	 * @param news
	 * @return
	 */
	public int insert(Connection con,News news) {
		return newsDao.insert(con, news);
		
	}
	
	/**
	 * 修改资讯
	 * @param con
	 * @param news
	 * @return
	 */
	public int update(Connection con,News news) {
		return newsDao.update(con, news);
		
	}
}
