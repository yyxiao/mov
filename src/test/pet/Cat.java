/**
 * Cat.java
 * com.test.pet
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月27日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package test.pet;

 
public class Cat extends Pet{

	@Override
	public void examine() {
		System.out.println("Cat meow!");
	}
	
	public Cat(String name){
		super(name);
	}
	
}
