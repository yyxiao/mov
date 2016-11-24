/**
 * DefaulableDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月11日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.test;

import java.util.function.Supplier;

 
/**
 * ClassName:DefaulableDemo
 *
 * (default demo--学习java8)
 *
 * @project mov
 *
 * @author xiaoyy
 *
 * @date   2016年4月11日 下午1:47:48	
 *
 * @class com.test.DefaulableDemo
 *
 */ 
public class DefaulableDemo {
	
	private interface Defaulable {
		default String notRequired(){
			return "Default implementation";
		}
	}
	
	private static class DefaultableImpl implements Defaulable{
		
	}
	
	private static class OverridableImpl implements Defaulable{
		@Override
		public String notRequired() {
			return "Test 重写default";
		}
	}
	
	private interface DefaulableFactory{
		static Defaulable create(Supplier<Defaulable> supplier){
			return supplier.get();
		}
	}
	
	public static void main(String[] args) {
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
		System.out.println(defaulable.notRequired());
		
		defaulable = DefaulableFactory.create(OverridableImpl::new);
		System.out.println(defaulable.notRequired());
	}

}
