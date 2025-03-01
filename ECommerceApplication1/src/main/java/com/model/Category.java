package com.model;

import javax.persistence.*;
import lombok.Data;
@Entity
@Data
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int cid;
	private String name;
}
