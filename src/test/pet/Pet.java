/**
 * Pet.java
 * com.test.pet
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月27日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package test.pet;

 
public abstract class Pet {
	
	protected final String name;
	
	public Pet(String name){
		this.name = name;
	}
	
	public abstract void examine();
	
}
