/**
 * JavaVMStackDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年5月26日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package run;

 
public class JavaVMStackDemo {
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args)throws Throwable{
		JavaVMStackDemo oom = new JavaVMStackDemo();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			System.out.println("stack length :" +oom.stackLength);
			throw e;
		}
	}
}
