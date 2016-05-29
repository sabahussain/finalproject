package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.*;
import com.dao.*;
import com.model.*;


@Controller
public class RegisterControllernew {
	
	 @Autowired
	   UserService userService;

	    @RequestMapping("/register")
	    public String registerCustomer(Model model){
	        User user = new User();
	        ShippingAddress shippingAddress = new ShippingAddress();
	       user.setShippingAddress(shippingAddress);
	        model.addAttribute("user", user);

	        return "registerCustomer";
	    }


	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String registerCustomerPost(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

	        if(result.hasErrors()){
	            return "registerCustomer";
	        }

	        List<User> userList = userService.getAllCustomers();

	        for (int i=0; i< userList.size(); i++){
	            if(user.getCustomerEmail().equals(userList.get(i).getCustomerEmail())){
	                model.addAttribute("emailMsg", "Email already exists");

	                return "registerCustomer";
	            }

	            if(user.getUsername().equals(userList.get(i).getUsername())){
	                model.addAttribute("usernameMsg", "Username already exists");

	                return "registerCustomer";
	            }
	        }

	        user.setEnabled(true);
	       userService.addCustomer(user);
	        return "registerCustomerSuccess";
	    }



}
