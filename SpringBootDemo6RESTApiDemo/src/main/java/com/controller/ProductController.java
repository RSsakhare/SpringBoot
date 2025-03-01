package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.model.*;
import com.service.*;

@RestController
public class ProductController 
{
	@Autowired
	ProductDaoImpl pdao;

	public void setPdao(ProductDaoImpl pdao)
	{
		this.pdao = pdao;
	}
	
	//http://localhost:8081/productmaster......GET
	@GetMapping("/productmaster")
	public String productmaster()
	{
		return "Hi ! welcome to REST API";
		
	}
	
	//http://localhost:8081/product/{pid}......GET
	@GetMapping("/product/{pid}")
	public Product getProduct(@PathVariable("pid") int pid) 
	{
		Product p = pdao.getProduct(pid);
		return p;
	}
	
	//http://localhost:8081/products......GET
	@GetMapping("/products")
	public ArrayList<Product> products()
	{
		return this.pdao.getProducts();
		
	}
	
	//http://localhost:8081/product......POST
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product prod)
	{
		return this.pdao.addProduct(prod);
		
	}
	
	//http://localhost:8081/product/{pid}......DELETE
		@DeleteMapping("/product/{pid}")
		public Product deleteProduct(@PathVariable("pid") int pid)
		{
			Product p = pdao.deleteProduct(pid);
			return p;
		}
		
		//http://localhost:8081/product/{pid}......PUT
		@PutMapping("/product/{pid}")
		public Product updateProduct(@PathVariable("pid") int pid,@RequestBody Product updatedProduct)
		{
			Product p = pdao.updateProduct(pid,updatedProduct);
			return p;
		}	
}
