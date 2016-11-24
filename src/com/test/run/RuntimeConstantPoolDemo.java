/**
 * RuntimeConstantPoolDemo.java
 * com.test.run
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年5月26日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.test.run;

 
/**
 * ClassName:RuntimeConstantPoolDemo
 *
 * 常量池demo
 *
 * @project mov
 *
 * @author xiaoyy
 *
 * @date   2016年5月26日 上午8:08:27	
 *
 * @class com.test.run.RuntimeConstantPoolDemo
 *
 */ 
public class RuntimeConstantPoolDemo {
	public static void main(String[] args) {
		//字符串常量池中不存在计算机软件
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern()==str1);
		//字符串常量池中已经存在java，请替换为java1试试
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern()==str2);
	}
}
