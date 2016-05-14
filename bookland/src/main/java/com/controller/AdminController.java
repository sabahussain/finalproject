package com.controller;

import com.model.Product;
import com.service.ProductService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class AdminController {
	@Autowired
	ProductService ps;
	
	@RequestMapping("/admin")
    public String listproduct(@ModelAttribute("product")Product product, Map<String, Object> model)
	{
		List<String> c = new ArrayList<String>();
	       c.add("Comic & Graphic Novel");
	       c.add("Literatue & Fiction Books");
	       c.add("Poetry");
	       c.add("Fantasy Books");
	       model.put("category", c);
           model.put("product", new Product());
           model.put("listproduct", ps.listProduct());
           return "admin";
    }

/* @RequestMapping(value= "/admin/add")
    public String addProduct(@Valid @ModelAttribute("product") Product p,BindingResult res,ModelMap model){
	 if(res.hasErrors())
	 {
	
	     model.addAttribute("listproduct", ps.listProduct());
		 return "admin";
	 }
         
        if(p.getId() == 0){
           ps.addProduct(p);
       
           }else{
            ps.updateProduct(p);
           
        }
         
        return "redirect:/admin";
         
    }
     */
    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
         
      ps.removeProduct(id);
        return "redirect:/admin";
    }
  
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Map<String, Object> model){
    	model.put("product", ps.getProductById(id));
        model.put("listproduct", ps.listProduct());
        return "admin";
    }
     
@RequestMapping(value="/uploadImage",method=RequestMethod.POST)
public String insertProduct(@Valid @ModelAttribute("product") Product p, HttpServletRequest request, BindingResult result,ModelMap model) throws IOException
{
	
	if(result.hasErrors())
	 {
	
	     model.addAttribute("listproduct", ps.listProduct());
		 return "admin";
	 }
	if(p.getId()==0)
	{
  ps.addProduct(p);
ServletContext context=request.getServletContext();
String rootPath=context.getRealPath("./resources/images/"+p.getId()+".jpg");
System.out.println("Path = "+rootPath);
MultipartFile m=p.getImg();
System.out.println(m);
File dir = new File(rootPath);
if(!m.isEmpty())
{
try
{
        byte[] bytes = p.getImg().getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(dir));
        stream.write(bytes);
        stream.close();
       System.out.println("File uploaded successfully");
}
catch(Exception e)
{
System.out.println(e);
}
List<Product> pr= (List<Product>) ps.listProduct();
model.addAttribute("listproduct",pr);
}	
	}
	else
	{
		  ps.updateProduct(p);
		  List<Product> pr= (List<Product>) ps.listProduct();
		  model.addAttribute("listproduct",pr);
          
	}
return "admin";	  
}


}