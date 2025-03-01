package com.service;

import java.util.ArrayList;

import com.model.*;

public interface ProductDaoInterface {

	public ArrayList<Product> getProducts();
	public Product getProduct(int pid);
	public Product addProduct(Product p);
	public Product deleteProduct(int pid);
	public Product updateProduct(int pid,Product updatedProduct);
	
}
