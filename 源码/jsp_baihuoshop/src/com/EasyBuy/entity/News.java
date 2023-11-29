package com.EasyBuy.entity;

import java.util.Date;

/**
 * 新闻咨询实体
 * @author Administrator
 *
 */
public class News {
	
	private Integer id;//编号id
	private String title;//新闻标题
	private String content;//内容
	private Date createTime;//创建时间
	
	
	
	public News(String title, String content, Date createTime) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	public News(Integer id, String title, String content, Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
