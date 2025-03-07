package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.global.GlobalData;
import com.model.Product;
import com.service.ProductService;

@Controller
public class CartController 
{
	@Autowired
	private ProductService productService;
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Long pid)
	{
		GlobalData.cart.add(productService.getProductById(pid).get());
		return "redirect:/shop";
	}
	
	@GetMapping("/cart")
	public String cartGet(Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice));
		model.addAttribute("cart" , GlobalData.cart);
		return "cart";
		
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String CartItemRemove(@PathVariable int index)
	{
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model)
	{
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice));
		return "checkout" ;
	}
}
