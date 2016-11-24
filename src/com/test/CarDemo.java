/**
 * CarDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月11日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

 
public class CarDemo {
	private final int a;
	
	private static class Car{
		public static Car create(final Supplier<Car> supplier){
			return supplier.get();
		}
		
		public static void collide(final Car car){
			System.out.println("Collided "+car.toString());
		}
		
		public void follow(final Car another){
			System.out.println("Following the "+another.toString());
		}
		
		public void repair(){
			System.out.println("Repaired "+this.toString());
		}
	}
	
	public static void main(String[] args) {
		Car car = Car.create(Car::new);
		List<Car> cars = Arrays.asList(car);
		
		cars.forEach(Car::collide);
		
		cars.forEach(Car::repair);
		
		Car police = Car.create(Car::new);
		cars.forEach(police::follow);
		CarDemo carDemo = new CarDemo();
	}

	public CarDemo(){
		a  = 1;
		System.out.println("测试构造方法："+a);
	}
}
