package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.model.Item;
import com.model.Product;
import com.service.ProductService;

@Controller
public class UserController {
	
	@Autowired
	ProductService ps;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView m=new ModelAndView("index");
		return m;
	}
	@RequestMapping("/index")
	public ModelAndView home1()
	{
		ModelAndView m=new ModelAndView("index");
		return m;
	}
	
	@RequestMapping("/register")
	public ModelAndView register()
	{
		ModelAndView m=new ModelAndView("register");
		return m;
	}
	@RequestMapping("/successForm")
	public ModelAndView register1()
	{
		ModelAndView m=new ModelAndView("successForm");
		return m;
	}
	@RequestMapping("/contactus")
	public ModelAndView contact()
	{
		ModelAndView m=new ModelAndView("contactus");
		return m;
	}
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView m=new ModelAndView("login");
		return m;
	}
	@RequestMapping("/product")
	public String product(Model model)
	{
		 Gson gson=new Gson();
	    	List<Product> list = ps.listProduct();
	    	System.out.println("list : "+list);
	    	String json=gson.toJson(list);
	    	System.out.println("inside controller");
	    	System.out.println(json);
	    	model.addAttribute("product", new Product());
	        model.addAttribute("listproduct", json.toString());
	    	return "product";
	}
	
	/*@RequestMapping("/productdetails")
	public String detail(@ModelAttribute("p")Product p,BindingResult result,Model m1)
	{
		m1.addAttribute("p",p);
		System.out.println("product details:"+p);
		return "productdetails";
	}*/
	
	@RequestMapping("/productdetails")
    public String productdetails(@ModelAttribute("p")Product p,BindingResult result,Model model){
    	model.addAttribute("p",p);
        return "productdetails";
    }
	@RequestMapping("/cartview")
    public String cartview(@ModelAttribute("p")Item p,BindingResult result,Model model){
    	model.addAttribute("p",p);
        return "cartview";
    }


}