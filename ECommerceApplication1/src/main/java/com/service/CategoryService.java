package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addCategory(Category category) 
	{
		categoryRepository.save(category);
	}
	
	public List<Category> getallCategory() 
	{
		 return categoryRepository.findAll();
	}
	
	public void removeCategoryByID(int cid)
	{
		categoryRepository.deleteById(cid);
	}
	
	public Optional<Category> getCategoryById(int cid)
	{
		return categoryRepository.findById(cid);
	}

	
}
