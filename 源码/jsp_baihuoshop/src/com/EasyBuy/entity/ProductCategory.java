package com.EasyBuy.entity;

/**
 * 商品分类实体
 * @author Administrator
 *
 */
public class ProductCategory {
	
	private Integer id;//编号
	private String  name;//名称
	private Integer parentId;//父级目录id
	private Integer type;//级别(1:一级 2：二级 3：三级)
	private String iconClass;//图标
	private String parentName;
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	
	

}
