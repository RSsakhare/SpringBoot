package com.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.model.*;
@Component
public class ProductDaoImpl implements ProductDaoInterface 
{
	ArrayList<Product> plist = null;
	
	public ProductDaoImpl() 
	{
		plist = new ArrayList<>();
		plist.add(new Product(101,"Monitor",15));
		plist.add(new Product(102,"Mouse",10));
		plist.add(new Product(103,"Keyboard",20));
	}

	@Override
	public ArrayList<Product> getProducts() 
	{
		
		return plist;
	}

	@Override
	public Product getProduct(int pid)
	{
		Product p= null;
		for(Product p1:plist)
		{
			if(p1.getPid()==pid)
			{
				p=p1;
				break;
			}
		}
		return p;
	}

	@Override
	public Product addProduct(Product p) 
	{
		this.plist.add(p);
		return p;
	}

	@Override
	public Product deleteProduct(int pid) 
	{
		Product p= null;
		for(Product p1:plist)
		{
			if(p1.getPid()==pid)
			{
				p=p1;
				this.plist.remove(p1);
				break;
			}
		}
		return p;
	}

  /*  @Override
	public Product updateProduct(int pid, Product updatedProduct) {
	    for (Product p1 : plist) {
	        if (p1.getPid() == pid) {
	            p1.setPname(updatedProduct.getPname());  //it use to update field that we want to update
	            p1.setPqty(updatedProduct.getPqty());
	            // Update other fields as necessary
	            return p1;
	        }
	    }
	    return null; // or throw an exception if the product is not found
	} */
	
	@Override
	public Product updateProduct(int pid, Product updatedProduct) {
	    for (int i = 0; i < plist.size(); i++) {
	        Product p1 = plist.get(i);
	        if (p1.getPid() == pid) {
	            plist.set(i, updatedProduct);    //in this method we have pass all value and their keys
	            return updatedProduct;
	        }
	    }
	    return null; // or throw an exception if the product is not found
	}


}
