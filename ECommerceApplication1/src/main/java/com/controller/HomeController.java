package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.global.GlobalData;
import com.service.*;

@Controller
public class HomeController
{
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("categories", categoryService.getallCategory());
		model.addAttribute("products", productService.getallProduct());
		model.addAttribute("cartCount", GlobalData.cart.size());
	
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model,@PathVariable int cid)
	{
		model.addAttribute("categories", categoryService.getallCategory());
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("products", productService.getAllProductByCategoryId(cid));
	
		return "shop";
	}
	
	@GetMapping("/shop/viewProduct/{id}")
	public String viewProduct(Model model,@PathVariable Long pid)
	{
		model.addAttribute("products", productService.getProductById(pid).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "viewProduct";
	}
	
	
}
