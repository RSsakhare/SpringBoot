package com.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Product
{
	private int pid;
	private String pname;
	private double price;
}
