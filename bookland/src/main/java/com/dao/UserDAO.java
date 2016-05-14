package com.dao;
import com.model.*;
import java.util.List;

public interface UserDAO {
	
	 void addUser(User user);

	  User getUserById(int customerId);

	    List<User> getAllUsers();

	    User getUserByUsername(String username);	

}
