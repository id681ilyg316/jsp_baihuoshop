package com.EasyBuy.entity;

public class CartItem {

	//购物买商品
	private Product product;
	//购买的数量
	private int goNum;
	private double cost;//单件商品总金额
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getGoNum() {
		return goNum;
	}
	public void setGoNum(int goNum) {
		this.goNum = goNum;
	}
}
