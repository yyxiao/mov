/**
 * LambdaDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月11日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

 
public class LambdaDemo {
	 
	public static void main(String[] args) {
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};  
		List<String> players =  Arrays.asList(atp); 
		System.out.println(players);
		List<String> players1 = players.stream().filter(a->a!="David Ferrer").limit(5).collect(Collectors.toList());
		System.out.println(players1);
		
		System.out.println("==RunnableTest==");
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};
		Runnable r2 = () -> System.out.println("Hello world two!");
		r1.run();
		r2.run();

		// Before Java 8
		new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println("Before Java8");
			}
		}).start();

		// Java 8 way
		new Thread(()-> System.out.println("In Java8")).start();

	}
	
}
