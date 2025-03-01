package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.dao.ProductRepository;
import com.model.Product;

import java.util.List;

@RestController
@CrossOrigin("*") // Replace with your frontend URL
public class ProductController 
{

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) 
    {
        return productRepository.findAll(PageRequest.of(page, 10)).getContent();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody Product product) 
    {
        return productRepository.save(product);
    }

    @GetMapping("/api/products/{pid}")
    public Product getProductById(@PathVariable int pid) 
    {
        return productRepository.findById(pid).orElse(null); // Add proper handling if not found
    }

    @PutMapping("/api/products/{pid}")
    public Product updateProduct(@PathVariable int pid, @RequestBody Product productDetails) 
    {
        Product product = productRepository.findById(pid).orElse(null);
        if (product == null) 
        {
            return null; // Could throw a ResourceNotFoundException here
        }
        product.setPname(productDetails.getPname());
        product.setPqty(productDetails.getPqty());
        return productRepository.save(product);
    }

    @DeleteMapping("/api/products/{pid}")
    public Product deleteProduct(@PathVariable int pid) 
    {
        Product product = productRepository.findById(pid).orElse(null);
        if (product == null)
        {
            return null; // Could throw a ResourceNotFoundException here
        }
        productRepository.delete(product); // Delete the product
        return product;
    }
}
