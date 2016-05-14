package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.*;
import com.service.*;
import com.dao.*;
import java.util.*;

@Service
@Transactional
public class OrderService {
	
	 @Autowired
	    OrderDAOImpl orderDao;

	    @Autowired
	    CartService cartService;
	
	public void addCustomerOrder(Order order)
	{
		orderDao.addCustomerOrder(order);
	}

    public float getCustomerOrderGrandTotal(int cartId)
    {
    
    	 float grandTotal = 0;
         Cart cart = cartService.getCartById(cartId);
         List<Item> cartItems = cart.getCartItems();

         for (Item item : cartItems){
             grandTotal += item.getTotalPrice();
         }

         return grandTotal;
    }

}
