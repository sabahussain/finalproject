package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAOImpl;
import com.model.*;

@Service
public class UserService {
	    @Autowired
	    UserDAOImpl userDaoImpl;

	    public void addCustomer(User user){
	    	userDaoImpl.addUser(user);
	    }

	    public User getCustomerById(int customerId){
	        return userDaoImpl.getUserById(customerId);
	    }

	    public List<User> getAllCustomers(){
	        return userDaoImpl.getAllUsers();
	    }

	    public User getCustomerByUsername (String username){
	        return userDaoImpl.getUserByUsername(username);
	    }


}
