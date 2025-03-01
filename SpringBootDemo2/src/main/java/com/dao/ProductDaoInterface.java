package com.dao;

import com.beans.Product;

public interface ProductDaoInterface 
{
	public int updateProduct(Product p);
	public int saveProduct(Product p);
	public int deleteProduct(Product p);
	public void showallProduct();
	
}
