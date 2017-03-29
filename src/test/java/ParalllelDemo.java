/**
 * ParalllelDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月12日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

 
/**
 * ClassName:ParalllelDemo
 *
 * (并行数组Demo-java8)
 *
 * @project mov
 *
 * @author xiaoyy
 *
 * @date   2016年4月12日 下午4:06:14	
 *
 * @class ParalllelDemo
 *
 */ 
public class ParalllelDemo {
	public static void main(String[] args) {
		long[] arrayOfLong = new long[20000];
		//在3333333中生成20000个随机数，乱序输出
		Arrays.parallelSetAll(arrayOfLong, index->ThreadLocalRandom.current().nextInt(3333333));
		Arrays.stream(arrayOfLong).limit(10).forEach(i->System.out.println(i+""));
		System.out.println();
		//生成20000个随机数，排序输出
		Arrays.parallelSort(arrayOfLong);
		Arrays.stream(arrayOfLong).limit(10).forEach(i->System.out.println(i+""));
		System.out.println();
	}
}
