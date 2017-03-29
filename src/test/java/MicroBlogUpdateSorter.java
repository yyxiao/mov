/**
 * MicroBlogUpdateSorter.java
 * com.test
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月29日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import java.util.Collections;
import test.lock.Author;
import test.lock.Update;

 
public class MicroBlogUpdateSorter extends RecursiveAction{

	private static final long serialVersionUID = 1L;
	private static final int SMALL_ENOUGH = 32;
	private final Update[] updates;
	private final int start, end;
	private final Update[] result;
	
	public MicroBlogUpdateSorter(Update[] updates){
		this(updates, 0, updates.length);
	}
	
	public MicroBlogUpdateSorter(Update[] updates2, int startPos, int endPos) {
		start = startPos;
		end = endPos;
		updates = updates2;
		result = new Update[updates.length];
	}
	
	private void merge(MicroBlogUpdateSorter left, MicroBlogUpdateSorter right){
		int i = 0;
		int lCt = 0;
		int rCt = 0;
		while(lCt < left.size() && rCt < right.size()){
			result[i++] = (left.result[lCt].compareTo(right.result[rCt])<0)?left.result[lCt++]:right.result[rCt++];
		}
		
	}

	public int size(){
		return end - start;
	}
	
	public Update[] getResult(){
		return result;
	}
	
	@Override
	protected void compute() {
		if(size()<SMALL_ENOUGH){
			System.arraycopy(updates, start, result, 0, size());
			Arrays.sort(result, 0, size());
		}else{
			int mid = size()/2;
			MicroBlogUpdateSorter left = new MicroBlogUpdateSorter(updates, start, start+mid);
			MicroBlogUpdateSorter right = new MicroBlogUpdateSorter(updates, start+mid, end);
			invokeAll(left, right);
			merge(left, right);
		}
	}

	public static void main(String[] args) {
		List<Update> lu = new ArrayList<>();
		String text = "";
		final Update.Builder ub = new Update.Builder();
		final Author a = new Author("Tallulah");
		
		for (int i = 0; i < 256; i++) {
			text = text + "X";
			long now = System.currentTimeMillis();
			lu.add(ub.author(a).updateText(text).createTime(now).build());
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Collections.shuffle(lu);
		Update[] updates = lu.toArray(new Update[0]);
		
		MicroBlogUpdateSorter sorter = new MicroBlogUpdateSorter(updates);
		ForkJoinPool pool = new ForkJoinPool(4);
		pool.invoke(sorter);
		
		for(Update u:sorter.getResult()){
			System.out.println(u);
		}
	}
}
