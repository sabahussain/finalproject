package com.dao;
import com.model.*;
import java.util.*;

interface ProductDAO {
	public List<Product> getAllProducts();
	public void addProduct(Product p);
	public void updateProduct(Product p);
	public Product getProductById(int id);
    public void removeProduct(int id);
}
