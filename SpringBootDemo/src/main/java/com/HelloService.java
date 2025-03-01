package com;

import org.springframework.stereotype.Service;

@Service("hsbean")
public class HelloService {

	public String sayHello(String sname) {
		return "Hi"+sname+"welcome to spring boot";
		
	}
}
