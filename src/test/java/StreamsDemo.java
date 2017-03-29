/**
 * StreamsDemo.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月11日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

 
/**
 * ClassName:StreamsDemo
 *
 * (集合操作java8)
 *
 * @project mov
 *
 * @author xiaoyy
 *
 * @date   2016年4月11日 下午5:56:45	
 *
 * @class StreamsDemo
 *
 */ 
public class StreamsDemo {
	
	private enum Status{
		CLOSE,OPEN
	}
	
	private static final class Task{
		private final Status status;
		private final Integer points;
		
		Task(final Status status, final Integer points){
			this.status = status;
			this.points = points;
		}
		
		public Integer getPoints(){
			return points;
		}
		
		public Status getStatus(){
			return status;
		}
		
		@Override
		public String toString(){
			return String.format("[%s,%d]", status, points);
		}
	}
	public static void main(String[] args) {
		final Collection<Task> tasks = Arrays.asList(
				new Task(Status.OPEN, 5),
				new Task(Status.OPEN, 13),
				new Task(Status.CLOSE, 8)
			);
		//.filter(task->task.getStatus()==Status.OPEN)可以省略
		final long totalPointsOfOpenTasks = tasks.stream().filter(task->task.getStatus()==Status.OPEN).mapToInt(Task::getPoints).sum();
		System.out.println("Total points:" + totalPointsOfOpenTasks);
		//获取总值
		final double totalPoints = tasks
				   .stream()
				   .parallel()
				   .map( task -> task.getPoints() ) // or map( Task::getPoints ) 
				   .reduce( 0, Integer::sum );
		System.out.println( "Total points (all tasks): " + totalPoints );
		//集合分组
		Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
		System.out.println(map);
		//集合比重
		final Collection<String> result = tasks.stream()
				.mapToInt(Task::getPoints)
				.asLongStream()
				.mapToDouble(points -> points / totalPoints)
				.boxed()
				.mapToLong(weigth->(long)(weigth*100))
				.mapToObj(percentage->percentage+"%")
				.collect(Collectors.toList());
		System.out.println(result);
	}
	
}
