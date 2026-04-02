package com.ecommerce.Order_Items.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer order_item_id;
	@Column(name="order_Id")
	private Integer orderId;
	@Column(name="product_id")
	private Integer productid;
	private Integer quantity;
	private Integer userId;
	private Integer price_at_order;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(Integer order_item_id) {
		this.order_item_id = order_item_id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProduct_id(Integer productid) {
		this.productid = productid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice_at_order() {
		return price_at_order;
	}
	public void setPrice_at_order(Integer price_at_order) {
		this.price_at_order = price_at_order;
	}
	
	

}
