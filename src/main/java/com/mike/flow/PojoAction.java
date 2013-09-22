package com.mike.flow;

import org.springframework.stereotype.Component;

@Component
public class PojoAction {
	
	public boolean doSomething(){
		System.out.println("**** Hello World ****");
		return true;
	}

}
