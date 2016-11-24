/**
 * Dog.java
 * com.test.pet
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月28日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.test.pet;

 
public class Dog extends Pet{

	public Dog(String name) {
		super(name);
	}

	@Override
	public void examine() {
		System.out.println("Woof!");
	}

}
