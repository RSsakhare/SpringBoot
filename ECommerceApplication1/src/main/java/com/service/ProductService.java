package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.*;
import com.repository.*;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getallProduct() 
	{
		 return productRepository.findAll();
	}
	
	public void addProduct(Product product) 
	{
		productRepository.save(product);
	}
	
	public void removeProductByID(Long pid)
	{
		productRepository.deleteById(pid);
	}
	
	public Optional<Product> getProductById(Long pid)
	{
		return productRepository.findById(pid);
	}
	
	public List<Product> getAllProductByCategoryId(int cid)
	{
		return productRepository.findAllByCategory_Cid(cid);
	}

	
}
