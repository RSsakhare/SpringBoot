package com.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dto.ProductDTO;
import com.model.*;
import com.service.*;


@Controller
public class AdminController 
{
	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/ststic/productImages";
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/admin")
	public String adminHomePage()
	{
		return "adminHome";
	}
	
	@GetMapping("/admin/categories")
	public String getCategories(Model model)
	{
		model.addAttribute("categories" , categoryService.getallCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCategoriesAdd(Model model)
	{
		model.addAttribute("category",new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCategoriesAdd(@ModelAttribute("category") Category category)
	{
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategory(@PathVariable int cid )
	{
		categoryService.removeCategoryByID(cid);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int cid,Model model )
	{
		Optional<Category> category = categoryService.getCategoryById(cid);
		if(category.isPresent())
		{
			model.addAttribute(" category" ,category.get());
			return "categoriesAdd";
		}
		else 
		{
			return "404";
		}
		
	}
	
	@GetMapping("/admin/products")
	public String getProducts(Model model )
	{
		model.addAttribute("products" , productService.getallProduct());
		return "products";
	}
	
	@GetMapping("/admin/products/add")
	public String addProducts(Model model )
	{
		model.addAttribute("productsDTO" , new ProductDTO());
		model.addAttribute("categories",categoryService.getallCategory());
		return "productsAdd";
	}
	
	@PostMapping("/admin/products/add")
	public String productsAddPost(@ModelAttribute("productDTO") ProductDTO productDTO , @RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName) throws IOException
	{
		Product product = new Product();
		product.setPid(productDTO.getPid());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setWeight(productDTO.getWeight());
		product.setDescription(productDTO.getDescription());
		String imageUUID;
		if(!file.isEmpty())
		{
			imageUUID= file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath,file.getBytes());
		}
		else
		{
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		productService.addProduct(product);
		
		return "redirect:/admin/products";
		
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable Long pid )
	{
		productService.removeProductByID(pid);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/update/{id}")
	public String updateProduct(@PathVariable Long pid,Model model) 
	{
		Product product = productService.getProductById(pid).get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPid(product.getPid());
		productDTO.setName(product.getName());
		productDTO.setCategoryId(product.getCategory().getCid());
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight(product.getWeight());
		productDTO.setDescription(product.getDescription());
		product.setImageName(product.getImageName());
		
		model.addAttribute("categories",categoryService.getallCategory());
		model.addAttribute("productDTO",productDTO);
		return "productsAdd";
	}
	
}
