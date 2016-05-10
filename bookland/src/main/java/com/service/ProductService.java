package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDAOImpl;
import com.model.Product;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductDAOImpl d;

	public void addProduct(Product p)
	{
	 d.addProduct(p);
	}
	public List<Product> listProduct()
	{
		return d.getAllProducts();
	}
	
	public void updateProduct(Product p) {
	       d.updateProduct(p);
	    }
	
	public Product getProductById(int id) {
	       return  d.getProductById(id);
	    }
	 
	public void removeProduct(int id) {
	        d.removeProduct(id);
	    }
	
}
