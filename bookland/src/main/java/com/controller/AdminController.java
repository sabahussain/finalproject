package com.controller;

import com.model.Product;
import com.service.ProductService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class AdminController {
	@Autowired
	ProductService ps;
	
	 @RequestMapping("/admin")
	    public String listproduct(Model model) {
	        Gson gson=new Gson();
	    	List<Product> list = ps.listProduct();
	    	System.out.println("list : "+list);
	    	String json=gson.toJson(list);
	    	System.out.println(json);
	    	model.addAttribute("product", new Product());
	        model.addAttribute("listproduct", json.toString());
	    	return "admin";
	    }

	 @RequestMapping(value= "/admin/add")
	    public String addProduct(@Valid @ModelAttribute("product") Product p,BindingResult res){
		 if(res.hasErrors()) {
	            return "admin";
	        }
	        if(p.getId() == 0){
	           ps.addProduct(p);	      
	           }else{
	            ps.updateProduct(p);
	        }
	         
	        return "redirect:/admin";
	         
	    }
	     
	    @RequestMapping("/remove/{id}")
	    public String removeProduct(@PathVariable("id") int id){
	         
	      ps.removeProduct(id);
	        return "redirect:/admin";
	    }
	  
	    @RequestMapping("/edit/{id}")
	    public String editProduct(@PathVariable("id") int id, Model model){
	    	model.addAttribute("product", ps.getProductById(id));
	        model.addAttribute("listproduct", ps.listProduct());
	        return "admin";
	    }
	    
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		  ModelAndView model = new ModelAndView();
		  if (error != null) {
			model.addObject("error", "Invalid username and password!");
		  }

		  if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		  }
		  model.setViewName("login");

		  return model;

		}
	
		@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

		  ModelAndView model = new ModelAndView();
			
		  //check if user is login
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();	
			model.addObject("username", userDetail.getUsername());
		  }
			
		  model.setViewName("accessdenied");
		  return model;

		}

	}

