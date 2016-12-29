/**
 * CacheDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年5月14日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package test;

 
/**
 * ClassName:CacheDemo
 *
 * 缓存未命中
 *
 * @project mov
 *
 * @author xiaoyy
 *
 * @date   2016年5月14日 下午2:58:57	
 *
 * @class CacheDemo
 *
 */ 
public class CacheDemo {
	private final int ARR_SIZE = 1*1024*1024;
	private final int[] arr =new int[ARR_SIZE];
	
	private void doLoop2(){
		for(int i=0;i<arr.length;i++){
			arr[i]++;
		}
	}
	
	private void doLoop1(){
		for(int i=0;i<arr.length;i+=16){
			arr[i]++;
		}
	}
	
	private void run(){
		for(int i=0;i<10000;i++){
			doLoop1();
			doLoop2();
		}
		
		for(int i=0;i<100;i++){
			long t0=System.nanoTime();
			doLoop1();
			long t1=System.nanoTime();
			doLoop2();
			long t2=System.nanoTime();
			long e1=t1-t0;
			long el2=t2-t1;
			System.out.println("Loop1:"+e1+"nanos;Loop2:"+el2);
		}
	}
	
	public static void main(String[] args) {
		CacheDemo ct = new CacheDemo();
		ct.run();
	}
}
