package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) 
	{
		ApplicationContext ac=SpringApplication.run(SpringBootDemoApplication.class, args);
		HelloService hsbean = (HelloService) ac.getBean("hsbean");
		System.out.println("\n"+hsbean.sayHello("Amit"));
		
		int count = ac.getBeanDefinitionCount();
		System.out.println("\n\nbean count:"+count);
		
		String bname[] = ac.getBeanDefinitionNames();
		System.out.println("\n\nbean names are \n:");
		for (int i = 0; i<bname.length;i++)
		{
			System.out.println(bname[i]);
			
		}
		
	}

}
