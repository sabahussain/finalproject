package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Order {

	@Id
	@GeneratedValue
	private int orderId;
	@OneToOne
    @JoinColumn(name = "cartId")
	private Cart cart;
	
	@OneToOne
    @JoinColumn(name = "customerId")
    private User user;
	 @OneToOne
	 @JoinColumn(name = "shippingAddressId")
	private ShippingAddress address;
	
	public int getOrderId() {
		return orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public ShippingAddress getAddress() {
		return address;
	}
	public void setAddress(ShippingAddress address) {
		this.address = address;
	}

	
}
