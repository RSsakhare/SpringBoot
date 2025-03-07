package com.model;

import javax.persistence.*;
import lombok.Data;
@Entity
@Data
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id",referencedColumnName = "category_id")
	private Category category;
	
	private double price;
	private double weight;
	private String description;
	private String imageName;
}
