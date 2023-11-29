package com.EasyBuy.entity;

import java.util.Date;

/**
 * 收货地址实体
 * @author Administrator
 *
 */
public class UserAddress {
	
	private Integer id;//编号
	private Integer userId;//用户编号
	private String address;//地址
	private Date createTime;//创建时间
	private Integer isDefault; //是否是默认地址（1:是 0否）
	private String remark;//备注
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
