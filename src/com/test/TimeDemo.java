/**
 * TimeDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月12日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

 
/**
 * ClassName:TimeDemo
 *
 * (时间优化-java8)
 *
 * @project mov
 *
 * @author xiaoyy
 *
 * @date   2016年4月12日 上午11:22:09	
 *
 * @class com.test.TimeDemo
 *
 */ 
public class TimeDemo {
	
	public static void main(String[] args) {
		Clock clock = Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());
		
		LocalDate date = LocalDate.now();
		LocalDate dateFromClock = LocalDate.now(clock);
		System.out.println(date);
		System.out.println(dateFromClock);
		
		LocalTime time = LocalTime.now();
		LocalTime timeFromClock = LocalTime.now(clock);
		System.out.println(time);
		System.out.println(timeFromClock);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
		ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(zonedDateTime);
		System.out.println(zonedDateTimeFromClock);
		System.out.println(zonedDateTimeFromZone);
		
		LocalDateTime from = LocalDateTime.of(2015, Month.MARCH, 16, 23, 59, 59);
		LocalDateTime to = LocalDateTime.of(dateFromClock, timeFromClock);
		Duration duration = Duration.between(from, to);
		System.out.println("Duration in days: " + duration.toDays());
		System.out.println( "Duration in hours: " + duration.toHours());
	}
	
}
