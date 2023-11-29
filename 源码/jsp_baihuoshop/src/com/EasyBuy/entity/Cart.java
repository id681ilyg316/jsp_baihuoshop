package com.EasyBuy.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类
 * @author Administrator
 *
 */
public class Cart {

	//结算金额
	private double totalMoney;
	
	//存储购物车的商品
	private List<CartItem> cartItems=new ArrayList<CartItem>();
	
	
	/**
	 * 添加到购物车中
	 * @param product
	 */
	public void addCart(Product product,String num) {
		CartItem cartItem=getExistsItem(product.getId());
		if(cartItem==null) { //购物暂无此商品
			cartItem=new CartItem();
			cartItem.setGoNum(Integer.parseInt(num));
			cartItem.setProduct(product);
			cartItem.setCost(1*product.getPrice());
			cartItems.add(cartItem);
		}else{
			cartItem.setGoNum(cartItem.getGoNum()+Integer.parseInt(num));
			cartItem.setCost(product.getPrice()*cartItem.getGoNum());
		}
		
		
		
	}
	
	public double getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	/**
	 * 判断商品是存放在购物车中，返回存在购物车的商品对象
	 * @param productId
	 */
	public CartItem getExistsItem(int productId) {
		CartItem returnCartItem=null;
		for (CartItem cartItem : cartItems) {
			if(cartItem.getProduct().getId()==productId) { //如果存在了返回为真
				returnCartItem=cartItem;
				break;
			}
		}
		return returnCartItem;
	}
}
