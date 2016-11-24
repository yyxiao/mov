/**
 * ThreadPoolDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xyy    2016年7月14日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

 
/**
 * ClassName:ThreadPoolDemo
 *
 * 线程池demo
 *
 * @project mov
 *
 * @author xyy
 *
 * @date   2016年7月14日 下午2:30:40	
 *
 * @class com.test.ThreadPoolDemo
 *
 */ 
public class ThreadPoolDemo {
	
	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 200, TimeUnit.DAYS, queue);
		for(int i = 0; i < 20; i++){
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(String.format("thread %d finished", this.hashCode()));
				}
			});
		}
		executor.shutdown();
	}

}
