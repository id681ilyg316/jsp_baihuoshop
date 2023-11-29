package com.EasyBuy.Service.News;

import java.sql.Connection;
import java.util.List;

import com.EasyBuy.entity.News;
import com.EasyBuy.entity.PageBean;

/**
 * 咨询Service接口
 * @author Administrator
 *
 */
public interface NewsService {
	
	/**
	 * 分页查询咨询
	 * @return
	 */
	public List<News> list(Connection con,PageBean pageBean);
	
	/**
	 * 查询商品总记录数
	 * @param con
	 * @return
	 */
	public int getCount(Connection con);
	
	/**
	 * 咨询id查询咨询详情
	 * @param con
	 * @param id
	 * @return
	 */
	public News findNewsDetail(Connection con,Integer id);
	
	/**
	 * 删除资讯
	 * @param con
	 * @param id
	 * @return
	 */
	public int delele(Connection con,Integer id);
	
	/**
	 * 添加资讯
	 * @param con
	 * @param news
	 * @return
	 */
	public int insert(Connection con,News news);
	
	/**
	 * 修改资讯
	 * @param con
	 * @param news
	 * @return
	 */
	public int update(Connection con,News news);
}
