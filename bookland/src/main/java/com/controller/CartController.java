package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.service.UserService;

@Controller
@RequestMapping("/user/cart")
public class CartController {
	    @Autowired
	    private UserService userService;

	    @RequestMapping
	    public String getCart(@AuthenticationPrincipal User activeUser){
	        User user = userService.getCustomerByUsername(activeUser.getUsername());
	        int cartId = user.getCart().getCartId();

	        return "redirect:/user/cart/" + cartId;
	    }

	    @RequestMapping("/{cartId}")
	    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
	        model.addAttribute("cartId", cartId);
	        return "cart";
	    }
}
