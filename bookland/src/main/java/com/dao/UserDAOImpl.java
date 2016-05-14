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
public class UserDAOImpl implements UserDAO{
	
	
	 @Autowired
	 private SessionFactory sessionFactory;

	public void addUser(User user) {
		 Session session = sessionFactory.getCurrentSession();
	        user.getShippingAddress().setUser(user);

	        session.saveOrUpdate(user);
	        session.saveOrUpdate(user.getShippingAddress());

	        Cart newCart = new Cart();
	        newCart.setUser(user);
	        user.setCart(newCart);

	        session.saveOrUpdate(user);
	        session.saveOrUpdate(newCart);

	        session.flush();
		
	}

	public User getUserById(int customerId) {
		 Session session = sessionFactory.getCurrentSession();
	        return (User) session.get(User.class, customerId);
	}

	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> userList = query.list();

        return userList;
	}

	public User getUserByUsername(String username) {
		  Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from User where username = ?");
	        query.setString(0, username);
         return (User) query.uniqueResult();
	}

}
