package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.*;
import com.model.*;

@Controller
public class OrderController {
	
	    @Autowired
	    private CartService cartService;

	    @Autowired
	    private OrderService customerOrderService;

	    @RequestMapping("/order/{cartId}")
	    public String createOrder(@PathVariable("cartId") int cartId){
	        Order customerOrder = new Order();
	        Cart cart = cartService.getCartById(cartId);
	        customerOrder.setCart(cart);
           User user=new User();
           customerOrder.setUser(user);
	       user.setShippingAddress(user.getShippingAddress());
	       customerOrderService.addCustomerOrder(customerOrder);
         return "thankscustomer";

	    }


}
