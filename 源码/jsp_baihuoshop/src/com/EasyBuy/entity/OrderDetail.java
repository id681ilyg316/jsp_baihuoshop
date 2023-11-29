package com.EasyBuy.entity;

/**
 * 订单明细实体
 * @author Administrator
 *
 */
public class OrderDetail {
	
	private Integer id;//编号
	private Integer orderId;//订单编号
	private Integer productId;//商品编号
	private int quantity;//数量
	private double cost;//消费额
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

}
