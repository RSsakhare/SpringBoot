package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemo1Application {

	public static void main(String[] args)
	{
		ApplicationContext ac=SpringApplication.run(SpringBootDemo1Application.class, args);
		Employee e = (Employee) ac.getBean("emp");
		System.out.println(e);
	}

}
