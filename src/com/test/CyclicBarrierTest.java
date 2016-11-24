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
package com.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

 
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
