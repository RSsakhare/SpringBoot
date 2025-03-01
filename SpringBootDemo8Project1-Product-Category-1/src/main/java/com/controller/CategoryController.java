package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.dao.CategoryRepository;
import com.model.Category;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoryController 
{

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/api/categories")
    public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) 
    {
        return categoryRepository.findAll(PageRequest.of(page, 10)).getContent();
    }

    @PostMapping("/api/categories")
    public Category createCategory(@RequestBody Category category) 
    {
        return categoryRepository.save(category);
    }

    @GetMapping("/api/categories/{cid}")
    public Category getCategoryById(@PathVariable int cid) 
    {
        return categoryRepository.findById(cid).orElse(null); 
    }

    @PutMapping("/api/categories/{cid}")
    public Category updateCategory(@PathVariable int cid, @RequestBody Category categoryDetails) 
    {
        Category category = categoryRepository.findById(cid).orElse(null);
        if (category == null) 
        {
            return null; 
        }
        category.setCname(categoryDetails.getCname()); // Update the fields
        return categoryRepository.save(category);
    }

    @DeleteMapping("/api/categories/{cid}")
    public Category deleteCategory(@PathVariable int cid) 
    {
        Category category = categoryRepository.findById(cid).orElse(null);
        if (category == null) 
        {
            return null; // Could throw a ResourceNotFoundException here
        }
        categoryRepository.delete(category); // Delete the category
        return category;
    }
}
