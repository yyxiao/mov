/**
 * TestSet.java
 * com.action
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月5日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package test;

import java.util.HashSet;
import java.util.Set;

 
public class TestSet {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("java");
		set.add("java");
		set.add("c");
		set.add("c++");
		set.add("C++");
		set.add("python");
		set.add("web");
		set.add("javascript");
		set.add("php");
		System.out.println(set.size());
		set.forEach(s->System.out.println(s));
	}

}
