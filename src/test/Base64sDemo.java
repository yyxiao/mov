/**
 * Base64sDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月12日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

 
/**
 * ClassName:Base64sDemo
 *
 * (base64转换)
 *
 * @project mov
 *
 * @author xiaoyy
 *
 * @date   2016年4月12日 下午1:49:54	
 *
 * @class Base64sDemo
 *
 */ 
public class Base64sDemo {
	
	public static void main(String[] args) {
		String text = "Base64 finally in Java 8!";
		
		String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);
		
		String decoded = new String(Base64.getDecoder().decode(encoded),StandardCharsets.UTF_8);
		System.out.println(decoded);
	}
	
}
