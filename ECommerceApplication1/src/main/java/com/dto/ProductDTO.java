package com.dto;

import lombok.Data;

@Data
public class ProductDTO 
{
	private Long pid;
	private String name;
	private int categoryId;
	
	private double price;
	private double weight;
	private String description;
	private String imageName;
}
