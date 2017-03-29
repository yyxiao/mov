/**
 * Update.java
 * com.test.lock
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月29日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package lock;

public class Update {

	public interface ObjBuilder<T>{
		T build();
	}
	
	private final Author author;
	private final String updateText;
	
	private Update(Builder b){
		author = b.author;
		updateText = b.updateText;
	}
	
	public static class Builder implements ObjBuilder<Update>{
		private Author author;
		private String updateText;
		
		public Builder author(Author author1){
			author = author1;
			return this;
		}
		
		public Builder updateText(String updateText1){
			updateText = updateText1;
			return this;
		}
		
		@Override
		public Update build() {
			return new Update(this);
		}

		public Builder createTime(long now) {
			return this;
		}
	}
	
	public int compareTo(Update update) {
		return 0;
	}
	
	
}
