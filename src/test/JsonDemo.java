/**
 * JsonDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年5月6日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package test;

import java.util.List;

import org.junit.Test;

 
public class JsonDemo {
	
	@Test
	public void StringToJson(){
		String a = "asdfadsfdsaf";
		String ab = toJson(a);
		System.out.println(ab);
	}
	
	
	private static String toJson(Object value){
		
		if(value instanceof String)
			return "\""+value+"\"";
		if(value instanceof List)
			return null;
		return "\"" + escape(value.toString()) + "\"";
		
	}
	
	private static String escape(String s) {
		if(s == null)
			return null;
        StringBuilder sb = new StringBuilder();
        escape(s, sb);
        return sb.toString();
    }
	
	private static void escape(String s, StringBuilder sb) {
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			switch(ch){
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				if((ch >= '\u0000' && ch <= '\u001F') || (ch >= '\u007F' && ch <= '\u009F') || (ch >= '\u2000' && ch <= '\u20FF')) {
					String str = Integer.toHexString(ch);
					sb.append("\\u");
					for(int k=0; k<4-str.length(); k++) {
						sb.append('0');
					}
					sb.append(str.toUpperCase());
				}
				else{
					sb.append(ch);
				}
			}
		}
	}
}
