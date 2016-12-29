/**
 * CyclicBarrierTest.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xyy    2016年7月10日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package test;

import java.util.concurrent.CyclicBarrier;


public class CyclicBarrierTest {
	static CyclicBarrier c = new CyclicBarrier(2);
	
	public static void main(String[] args) {
		new Runnable() {
			
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(1);
			}
		};
		try {
			c.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(2);
	}
	
}
