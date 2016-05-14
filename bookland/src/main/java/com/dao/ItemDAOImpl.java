package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.*;

@Repository
@Transactional
public class ItemDAOImpl implements ItemDAO {
	
	 @Autowired
	 SessionFactory sessionFactory;

	public void addCartItem(Item item) {
		 Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(item);
	        session.flush();
		
	}

	public void removeCartItem(Item item) {
		 Session session = sessionFactory.getCurrentSession();
	        session.delete(item);
	        session.flush();
		
	}

	public void removeAllCartItems(Cart cart) {
		  List<Item> cartItems = cart.getCartItems();

	        for (Item item : cartItems){
	            removeCartItem(item);
	        }
		
	}

	public Item getCartItemByProductId(int id) {
		 Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from Item where itemId = ?");
	        session.flush();

	        return (Item) query.uniqueResult();
	}

}
