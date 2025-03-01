package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.model.Employee;
import com.model.Product;
import com.model.Student;

@SpringBootApplication
public class SpringBootDemo8LogOnApplication {

	public static void main(String[] args) 
	{
		ApplicationContext ac= SpringApplication.run(SpringBootDemo8LogOnApplication.class, args);
		
		Employee e = ac.getBean(Employee.class);
		System.out.println("Employee Details are :");
		System.out.println(e);
		e.setEid(101);
		e.setEname("Amit");
		e.setEsal(125221);
		System.out.println(e);
		
		Student s = ac.getBean(Student.class);
		System.out.println("Student Details are :");
		System.out.println(s);
		s.setSid(101);
		s.setSname("Amit");
		s.setSper(52.6);
		System.out.println(s);
		
		Product p = Product.builder()
				.pid(102)
				.pname("Monitor")
				.price(12000)
				.build();
		System.out.println(p);
	}

}
